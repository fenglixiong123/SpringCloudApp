package com.flx.springcloud.nacos.api.user.service;

import com.flx.springcloud.nacos.api.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/22 14:16
 * @Description:
 */
@FeignClient(name = "microservice-nacos-provider")
public interface IUserService {

    @GetMapping(value = "/provider/user/get/{id}")
    User get(@PathVariable(value = "id") Long id);

    @GetMapping(value = "/provider/user/list")
    List<User> findUserAll();

}
