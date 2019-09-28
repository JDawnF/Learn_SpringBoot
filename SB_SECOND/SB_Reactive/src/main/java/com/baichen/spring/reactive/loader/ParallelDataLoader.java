package com.baichen.spring.reactive.loader;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date: 2019-09-28 23:27
 * @Author: baichen
 * @Description: 并行加载器
 * 明显地，程序改造为并行加载后，性能和资源利用率得到提升，消耗时间取最大者。
 */
public class ParallelDataLoader extends DataLoader{
    protected void doLoad() { // 并行计算
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 创建线程池
        CompletionService completionService = new ExecutorCompletionService(executorService);
        // 启动线程需要耗时
        completionService.submit(super::loadConfigurations, null);   // 耗时 >= 1s
        completionService.submit(super::loadUsers, null);       // 耗时 >= 2s
        completionService.submit(super::loadOrders, null);      // 耗时 >= 3s
        int count = 0;
        while (count < 3) { // 等待三个任务完成
            if (completionService.poll() != null) {
                count++;
            }
        }
        executorService.shutdown();
    } // 总耗时 max(1s, 2s, 3s) >= 3s

    public static void main(String[] args) {
        new ParallelDataLoader().load();
    }
}
