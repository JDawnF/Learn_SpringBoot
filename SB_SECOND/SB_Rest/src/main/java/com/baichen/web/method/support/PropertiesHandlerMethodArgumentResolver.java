package com.baichen.web.method.support;

import com.baichen.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

/**
 * {@link Properties 类型} {@link HandlerMethodArgumentResolver}
 * 扩展rest内容协商，自定义HandlerMethodArgumentResolver
 * @author baichen
 * @since 2019/9/21
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Properties.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        // 复用 PropertiesHttpMessageConverter
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();
        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;//强转为ServletWebRequest
        // Servlet Request API
        HttpServletRequest request = servletWebRequest.getRequest();
        HttpInputMessage httpInputMessage = new ServletServerHttpRequest(request);
        return converter.read(null, null, httpInputMessage);
    }
}
