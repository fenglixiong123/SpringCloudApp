package com.flx.app.controller;

import com.flx.springboot.entity.Dept;
import com.flx.app.service.service.IUserClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Fenglixiong
 * @Date: 2021/4/22 19:57
 * @Description:
 */
@Slf4j
@RestController
public class UserHystrixController {

    @Autowired
    private IUserClientService userClientService;

    /**
     * 若出现异常则调用@HystrixCommand里面的方法处理
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    @RequestMapping(value = "/user/get/{id}",method = RequestMethod.GET)
    public Object getUser(@PathVariable("id")Long id){
        log.info(">>>>user get:"+id);
        return userClientService.getUser(id);
    }

    /**
     * 处理熔断信息
     * @param id
     * @return
     */
    public Dept processHystrix_Get(Long id){
        Dept dept = new Dept()
                .setDeptno(id)
                .setDname("该ID:"+id+"没有对应信息，Provider服务端提供的熔断服务，此方法已经进入异常！")
                .setDb_source("服务熔断");
        log.info("Enter hystrix...return："+dept);
        return dept;
    }

}
