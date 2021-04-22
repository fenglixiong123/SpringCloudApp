package com.flx.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: Fenglixiong
 * @Date: 2021/4/22 19:51
 * @Description:
 */
@RestController
public class UserRestController {

    private static final String prefix = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/user/list")
    public List list(){
        return restTemplate.getForObject(prefix + "/user/list", List.class);
    }

}
