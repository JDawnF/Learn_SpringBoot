package com.baichen.webmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * {@link DispatcherServlet} 配置类,替换了web.xml
 * @author baichen
 *
 */
@ComponentScan(basePackages = "com.baichen.webmvc") // 包扫描
public class DispatcherServletConfiguration {
}
