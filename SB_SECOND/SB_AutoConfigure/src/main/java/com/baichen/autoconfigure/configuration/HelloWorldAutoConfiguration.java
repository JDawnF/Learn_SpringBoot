package com.baichen.autoconfigure.configuration;

import com.baichen.autoconfigure.annotation.EnableHelloWorld;
import com.baichen.autoconfigure.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld 自动装配
 * @author baichen
 */
@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "baichen") // 条件装配
public class HelloWorldAutoConfiguration {
}
