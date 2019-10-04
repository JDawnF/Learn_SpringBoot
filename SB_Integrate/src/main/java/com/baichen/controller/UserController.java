package com.baichen.controller;

import com.baichen.pojo.JsonResult;
import com.baichen.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Date: 2019-10-04 12:45
 * @Author: baichen
 * @Description 返回JSON数据
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setName("mybaichen2");
        user.setPassword("mybaichen");
        user.setAge(22);
        user.setBirthday(new Date());
        user.setNote("Hello");
        return user;
    }

    @GetMapping("/getUserJson")
    public JsonResult getUserJson(){
        User user = new User();
        user.setName("mybaichen2");
        user.setPassword("mybaichen");
        user.setAge(22);
        user.setBirthday(new Date());
        user.setNote("Hello");
        return JsonResult.ok(user);
    }

}
