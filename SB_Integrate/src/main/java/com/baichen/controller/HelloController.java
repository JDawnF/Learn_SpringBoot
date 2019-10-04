package com.baichen.controller;

import com.baichen.pojo.JsonResult;
import com.baichen.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019-10-04 12:29
 * @Author: baichen
 * @Description 基于REST的Controller,返直接返回方法的响应内容
 */
@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public Object hello() {
        return "hello springboot~~";
    }

    @RequestMapping("/getResource")
    public JsonResult getResource() {

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return JsonResult.ok(bean);
    }

}
