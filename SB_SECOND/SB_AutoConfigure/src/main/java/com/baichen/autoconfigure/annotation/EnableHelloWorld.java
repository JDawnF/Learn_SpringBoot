package com.baichen.autoconfigure.annotation;

import com.baichen.autoconfigure.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *  激活 HelloWorld 模块，@Enable模块装配注解
 * @author baichen
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
//@Import(HelloWorldConfiguration.class)
@Import(HelloWorldImportSelector.class) // 通过selector实现bean的调用
public @interface EnableHelloWorld {
}
