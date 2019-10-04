package com.baichen.controller;

import com.baichen.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @Date: 2019-10-04 18:48
 * @Author: baichen
 * @Description 整合 Thymeleaf
 */
@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-imooc");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public String test(ModelMap map) {

        User u = new User();
        u.setName("superadmin");
        u.setAge(10);
        u.setPassword("123465");
        u.setBirthday(new Date());
        u.setNote("<font color='green'><b>hello imooc</b></font>");

        map.addAttribute("user", u);

        User u1 = new User();
        u1.setAge(19);
        u1.setName("imooc");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("baichen");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);
        map.addAttribute("userList", userList);
        return "thymeleaf/test";   // 跳转到对应的页面
    }

    @PostMapping("postform")
    public String postform(User user) {

        System.out.println("姓名：" + user.getName());
        System.out.println("年龄：" + user.getAge());

        return "redirect:/th/test";  // 跳转到controller中对应的路径
    }

    @RequestMapping("showerror")
    public String showerror(User user) {

        int a = 1 / 0;

        return "redirect:/th/test";
    }
}
