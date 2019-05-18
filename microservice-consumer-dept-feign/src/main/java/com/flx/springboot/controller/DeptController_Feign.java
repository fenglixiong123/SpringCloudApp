package com.flx.springboot.controller;

import com.flx.springboot.entity.Dept;
import com.flx.springboot.service.IDeptClientService;
import com.flx.springboot.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 19:14
 */
@RestController
@RequestMapping("/feign")
public class DeptController_Feign {

    private static final Logger logger = LoggerFactory.getLogger(DeptController_Feign.class);

    @Autowired
    private IDeptClientService deptClientService;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        logger.info(">>>>>dept add:"+ CommonUtils.getJsonString(dept));
        return deptClientService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        logger.info(">>>>>dept get:"+id);
        return deptClientService.get(id);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        logger.info(">>>>>dept list");
        return deptClientService.list();
    }

}
