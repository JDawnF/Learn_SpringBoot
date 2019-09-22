package com.baichen.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Rest 引导类
 *
 * @author baichen
 * @since 2019/9/21
 */
@SpringBootApplication(scanBasePackages = {
        "com.baichen.web.controller",
        "com.baichen.web.config"
})
public class SpringBootRestBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class, args);
    }
}
