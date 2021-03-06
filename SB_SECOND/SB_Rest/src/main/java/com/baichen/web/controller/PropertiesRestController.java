package com.baichen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * {@link Properties} {@link RestController}
 *
 * @author baichen
 * @since 2019/9/21
 */
//@RestController
@Controller
public class PropertiesRestController {

    @PostMapping(value = "/add/props",
            consumes = "text/properties;charset=UTF-8" // Content-Type 过滤媒体类型
    )
    public Properties addProperties(
//            @RequestBody
            Properties properties) {
        return properties;
    }

}
