package com.baichen.exception;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date: 2019-10-04 23:33
 * @Author: baichen
 * @Description Web请求 异常捕获
 */
public class WebExceptionHandler {

    private static final String ERROR_VIEW = "error";

    /**
     * //    @ExceptionHandler(Exception.class)
     */
    public Object handler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(ERROR_VIEW);
        return mav;
    }
}
