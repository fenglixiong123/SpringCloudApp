package com.flx.springcloud.nacos.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/18 15:54
 * @Description: 注意：配置也可以写在service中，但是必须要注意分隔符是.而不能用_
 */
@Slf4j
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${user.name:jack}")
    private String userName;

    @RequestMapping("/get")
    public String get() {
        return userName;
    }

}
