package com.baichen.dive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Date: 2019-09-09 23:07
 * @Author: baichen
 * @Description
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.baichen.dive.web.servlet")
public class BootDiveApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootDiveApplication.class, args);
    }
}
