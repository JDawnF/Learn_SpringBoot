package com.baichen.webmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * {@link HelloWorldController} 通知
 *
 * @author baichen
 *
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)// 切面通知
public class HelloWorldControllerAdvice {

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage){
        return acceptLanguage;
    }

    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId){
        return jsessionId;
    }

    @ModelAttribute("message")
    public String message(){
        return "Hello,World";
    }

    @ExceptionHandler(Throwable.class) // 拦截异常
    public ResponseEntity<String> onException(Throwable throwable) {
        return ResponseEntity.ok(throwable.getMessage());
    }

}
