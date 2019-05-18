package com.flx.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/8 19:17
 */
@RestController
public class HelloController {

    @Value("${hobby}")
    private String hobby;

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/hobby")
    public Object getHobby(){
        String result = "appName="+appName+",hobby="+hobby;
        System.out.println("从ConfigServer处获得的配置："+result);
        return result;
    }

}
