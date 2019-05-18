package com.flx.springboot.controller;

import com.flx.springboot.entity.Dept;
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
 * @Date: Created in 2018/5/3 19:38
 */
@RestController
public class DeptController_Consumer {

    private static final Logger logger = LoggerFactory.getLogger(DeptController_Consumer.class);

    private static final String prefix = "http://localhost:8001";

    //提供了多种远程访问Http服务的方法
    //是一种简单的访问restful服务模板类，是Spring提供的用于访问rest服务的的客户端模板工具集
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        logger.info("=====add");
        return restTemplate.postForObject(prefix+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        logger.info("=====get");
        return restTemplate.getForObject(prefix+"/dept/get/"+id,Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        logger.info("====list");
        return restTemplate.getForObject(prefix+"/dept/list",List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        logger.info("=====discovery");
        return restTemplate.getForObject(prefix+"/home/discovery",Object.class);
    }

}
