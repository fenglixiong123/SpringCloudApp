package com.flx.springboot.controller;

import com.flx.springboot.entity.User;
import com.flx.springboot.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 17:57
 */
@RestController
@RequestMapping("/ribbon")
public class UserController_Consumer {

    private static final Logger logger = LoggerFactory.getLogger(UserController_Consumer.class);

    private static final String prefix = "http://microservice-config-client-user-provider";

    //提供了多种远程访问Http服务的方法
    //是一种简单的访问restful服务模板类，是Spring提供的用于访问rest服务的的客户端模板工具集
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/user/{id}")
    public User get(@PathVariable("id")Long id){
        logger.info("=====user get");
        return restTemplate.getForObject(prefix+"/user/get/"+id,User.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/user/list")
    public List<User> list(){
        logger.info("====user list");
        return restTemplate.getForObject(prefix+"/user/list",List.class);
    }

}
