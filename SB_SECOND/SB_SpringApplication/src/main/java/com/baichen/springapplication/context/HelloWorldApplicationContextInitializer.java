package com.baichen.springapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 实现自定义配置的ApplicationContextInitializer
 * @author baichen
 */
@Order(Ordered.HIGHEST_PRECEDENCE)  //排序
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext>
        implements ApplicationContextInitializer<C> {
    @Override
    public void initialize(C applicationContext) {
        System.out.println("ConfigurableApplicationContext.id = "+ applicationContext.getId());
    }
}
