package com.flx.springcloud.nacos.provider.controller;

import com.flx.springcloud.nacos.api.user.entity.User;
import com.flx.springcloud.nacos.provider.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/22 15:17
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/provider/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/get/{id}")
    public User get(@PathVariable(value = "id") Long id){
        log.info("provider get id = {}",id);
        return userService.findUserById(id);
    }

    @GetMapping(value = "/list")
    public List<User> findUserAll(){
        log.info("provider findUserAll");
        return userService.findUserAll();
    }

    @PostMapping(value = "/update")
    public String update(@RequestBody User user){
        log.info("provider update,{}",user);
        return user.toString();
    }


}
