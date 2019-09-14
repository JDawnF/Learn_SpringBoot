package com.baichen.autoconfigure.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 派生性
 * 二级 {@link Repository}
 * @author baichen
 * 包含了@FirstLevelRepository，而@FirstLevelRepository中包含了@Repository
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}
