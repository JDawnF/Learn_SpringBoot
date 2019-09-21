package com.baichen.web.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Spring Web MVC 配置（类）
 *
 * @author baichen
 * @since 2018/5/20
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //     <!--<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">-->
//        <!--<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>-->
//        <!--<property name="prefix" value="/WEB-INF/jsp/"/>-->
//        <!--<property name="suffix" value=".jsp"/>-->
//    <!--</bean>-->
    // 修改自定义ViewResolver顺序
    @Bean
    public ViewResolver myViewResolver() {
        // InternalResourceViewResolver:JSP解析的ViewResolver，优先级：Ordered.LOWEST_PRECEDENCE
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        // ThymeleafViewResolver :Ordered.LOWEST_PRECEDENCE - 5
        viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);// 优先级高于 ThymeleafViewResolver
        // 配置 ViewResolver 的 Content-Type,在ContentNegotiatingViewResolver中会读取不同的ContentType做不同处理
        viewResolver.setContentType("text/xml;charset=UTF-8");
        return viewResolver;
    }

    // 可以关联配置策略
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
                .favorPathExtension(true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("拦截中...");
                return true;
            }
        });
    }

    //DocumentRoot中配置了一个默认路径，但是因为用户的home目录和dir(工作)目录是不同的,而多模块的时候，工作目录是父工程所在的路径，
    // 所以无法读取到子模块的路径，因此无法读取jsp页面
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return (factory) -> { //factory是个对象
            factory.addContextCustomizers((context) -> {
                        String relativePath = "springboot-view/src/main/webapp";
                        // 相对于 user.dir = D:\workspace\dive-in-spring-boot
                        File docBaseFile = new File(relativePath);
                        if(docBaseFile.exists()) { // 路径是否存在
                            // 解决 Maven 多模块 JSP 无法读取的问题
                            context.setDocBase(docBaseFile.getAbsolutePath());
                        }
                    }
            );
        };
    }
}
