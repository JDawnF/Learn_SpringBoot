package com.baichen.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 视图引导类
 *
 * @author baichen
 * @since 2019-09-18
 */
@SpringBootApplication(scanBasePackages = "com.baichen.web") // 因为跟controller不在同个目录，所以要扫描包
public class SpringBootViewBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootViewBootstrap.class, args);
    }
}
