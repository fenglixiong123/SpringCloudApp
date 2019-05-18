package com.flx.springboot.controller;

import com.flx.springboot.entity.Dept;
import com.flx.springboot.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/3 17:12
 */
@RestController
public class DeptController {

    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        logger.info("-----add:"+dept);
        return deptService.add(dept);
    }

    /**
     * 若出现异常则调用@HystrixCommand里面的方法处理
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.get(id);
        logger.info("-----get："+dept);
        if(null==dept){
            throw new RuntimeException("该ID:"+id+"没有返回对应的信息！");
        }
        return dept;
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        List<Dept> deptList = deptService.list();
        logger.info("------lst:"+deptList);
        throw new RuntimeException();
//        return deptList;
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
        logger.info("Enter hystrix...return："+dept);
        return dept;
    }

}
