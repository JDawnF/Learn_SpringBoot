package com.baichen.simple.controller;

import com.baichen.simple.domain.User;
import com.baichen.simple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019-09-08 21:06
 * @Author: baichen
 * @Description
 * 标题: 用户 REST 接口<br>
 * 描述: RESTFul 格式<br>
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if (userRepository.save(user)){
            System.out.printf("用户对象： %s 保存成功\n",user);
        }
        return user;
    }
}
