package com.flx.springboot.service;

import com.flx.springboot.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: Fenglixiong
 * @Date: 2021/4/22 20:35
 * @Description:
 */
@FeignClient(value = "microservice-user-consul-provider",path = "/consul/provider/user")
public interface ConsulUserService {

    @GetMapping(value = "/get/{id}")
    User getUser(@PathVariable("id") Long id);

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    List<User> listUser();

}
