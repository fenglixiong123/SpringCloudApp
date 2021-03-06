package com.flx.app.controller;

import com.flx.springboot.entity.User;
import com.flx.springboot.service.ConsulUserService;
import com.flx.springboot.service.EurekaUserClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 19:46
 */
@RestController
@RequestMapping("/consul/consumer")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ConsulUserService userClientService;

    @RequestMapping(value = "/user/get/{id}",method = RequestMethod.GET)
    public Object getUser(@PathVariable("id")Long id){
        logger.info(">>>>user get:"+id);
        return userClientService.getUser(id);
    }

    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public List<User> listUser(){
        logger.info(">>>>>>user list");
        return userClientService.listUser();
    }
}
