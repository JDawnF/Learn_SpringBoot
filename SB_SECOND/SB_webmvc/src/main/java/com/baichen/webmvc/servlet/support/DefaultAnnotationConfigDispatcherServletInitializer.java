package com.baichen.webmvc.servlet.support;

import com.baichen.webmvc.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web MVC 自动装配 默认实现
 * @author baichen
 */
public class DefaultAnnotationConfigDispatcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { // web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // DispatcherServlet
        return new Class[]{DispatcherServletConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() { // DispatcherServlet的映射
        return new String[]{"/"};
    }
}
