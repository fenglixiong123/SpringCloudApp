package com.flx.springboot.controller;

import com.flx.springboot.entity.User;
import com.flx.springboot.service.UserService;
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
 * @Date: Created in 2018/5/7 16:14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Object getUser(@PathVariable("id")Long id){
        User user = userService.findUserById(id);
        logger.info("====findUserById:"+user);
        return user;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> listUser(){
        List<User> userList = userService.findUserAll();
        logger.info("====userList:"+userList);
        return userList;
    }

}
