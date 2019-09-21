package com.baichen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloWorld {@link Controller}
 *
 * @author baichen
 * @since 2019-09-18
 */
@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(@RequestParam(required = false,defaultValue = "0") int value, Model model) {
        return "index";
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world"; // View 逻辑名称
    }

    @ModelAttribute("message") // 要加上变量名称，才能将返回的数据输出到页面
    public String message() {
        return "HelloWorld";
    }
}
