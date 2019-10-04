package com.baichen.controller;

import com.baichen.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Date: 2019-10-04 18:47
 * @Author: baichen
 * @Description 整合 Freemarker
 */
@Controller
@RequestMapping("ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @GetMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("resource",resource);
        return "freemarker/index";   // 跳转到对应页面
    }

    @GetMapping("/center")
    public String center(){
        return "freemarker/center/center";
    }
}
