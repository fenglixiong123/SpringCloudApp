package com.flx.springcloud.nacos.consumer.controller;

import com.flx.springcloud.nacos.api.user.entity.User;
import com.flx.springcloud.nacos.api.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/22 15:24
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/consumer/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/get/{id}")
    public User get(@PathVariable Long id){
        log.info("consumer get id = {}",id);
        return userService.get(id);
    }

    @GetMapping("/list")
    public List<User> findUserAll(){
        log.info("consumer findUserAll");
        return userService.findUserAll();
    }

}
