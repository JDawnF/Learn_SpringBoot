package com.baichen.spring.reactive.loader;

import java.util.concurrent.CompletableFuture;

/**
 * @Date: 2019-09-29 22:28
 * @Author: baichen
 * @Description 理解 Future 链式问题
 * 由于 Future 无法实现异步执行结果链式处理，尽管 FutureBlockingDataLoader 能够解决方法数据依赖
 * 以及顺序执行的问题，不过它将并行执行带回了阻塞(串行)执行,CompletableFuture 可以帮助提升 Future 的限制
 */
public class ChainDataLoader extends DataLoader {
    protected void doLoad() {
        // main -> submit -> ...
            // sub-thread : F1 -> F2 -> F3
        CompletableFuture
                .runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                .whenComplete((result, throwable) -> { // 完成时回调,都是同个线程
                    System.out.println("[线程 : "+Thread.currentThread().getName()+" ] 加载完成");
                })
                .join(); // 等待完成
    }
    public static void main(String[] args) {
        new ChainDataLoader().load();
    }
}
