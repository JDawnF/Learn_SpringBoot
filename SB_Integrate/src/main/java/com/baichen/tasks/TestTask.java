package com.baichen.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @Date: 2019-10-05 11:11
 * @Author: baichen
 * @Description 测试定时任务,自定义定时任务
 */
@Component
public class TestTask {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    /**
     * 定义每过3秒执行任务
     * 支持使用 @Scheduled(cron = "4-40 * * * * ?") cron表达式
     */
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + DATE_FORMAT.format(new Date()));
    }
}
