package com.baichen.autoconfigure.configuration;

import org.springframework.context.annotation.Bean;

/**
 * HelloWorld 配置
 * @author baichen
 */
public class HelloWorldConfiguration {
    @Bean
    public String helloWorld() { // 方法名即 Bean 名称
        return "Hello,World 2019";
    }
}
