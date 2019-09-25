package com.baichen.spring.web.servlet.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Hello World 异步 {@link RestController}
 * @author baichen
 * @since 2019/9/22
 */
@RestController
@EnableScheduling  // 周期调度
public class HelloWorldAsyncController {

    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);
    // 超时随机数
    private final Random random = new Random();
    @Scheduled(fixedRate = 5000)  // 固定5000ms
    public void process() throws InterruptedException { // 定时操作
        DeferredResult<String> result = null;
        do {
            result = queue.take();
            // 随机超时时间
            long timeout = random.nextInt(100);
            // 模拟等待时间，RPC 或者 DB 查询
            Thread.sleep(timeout);
            // 计算结果
            result.setResult("Hello,World");
            println("执行计算结果，消耗：" + timeout + " ms.");
        } while (result != null);
    }

    @GetMapping("/completion-stage")
    public CompletionStage<String> completionStage(){   // 函数式编程
        final long startTime = System.currentTimeMillis();
        println("Hello,World");
        return CompletableFuture.supplyAsync(()->{
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗：" + costTime + " ms.");
            return "Hello,World"; // 异步执行结果
        });
    }

    @GetMapping("/callable-hello-world")
    public Callable<String> callableHelloWorld() {
        final long startTime = System.currentTimeMillis();
        println("Hello,World");
        return () -> {
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗：" + costTime + " ms.");
            return "Hello,World";
        };
    }

    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld() { // 返回异步接口
        /**
         *  默认构造器最终调用的是这个重载构造器
         *  Create a DeferredResult with a timeout value and a default result to use
         * in case of timeout.
         * @param timeout timeout value in milliseconds (ignored if {@code null})
         * @param timeoutResult the result to use
         * public DeferredResult(@Nullable Long timeout, Object timeoutResult) {
         * 		this.timeoutResult = timeoutResult;
         * 		this.timeout = timeout;
         *        }
         */
        DeferredResult<String> result = new DeferredResult<>(50L);
//        result.setResult("Hello,World");
        // 入队操作
//        queue.offer(result);
        println("Hello,World"); //两个打印方法查看是否为同个线程，如果不同则为异常
        result.onCompletion(() -> { //相当于finally输出的语句
            println("执行结束");
        });
        result.onTimeout(() -> { // 相当于try...catch捕获的异常
            println("执行超时");
        });
        return result;
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController[" + threadName + "]: " + object);// 打印当前线程
    }

}
