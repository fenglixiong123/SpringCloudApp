package com.flx.springboot.service;

import com.flx.springboot.service.fallback.UserClientServiceFallbackFactory;
import com.flx.springboot.utils.CommonUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 19:07
 */
@FeignClient(value = CommonUtils.MICROSERVICE_PROVIDER_DEPT,fallbackFactory = UserClientServiceFallbackFactory.class)
public interface IDeptClientService {

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    boolean add(@RequestBody Dept dept);

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    Dept get(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    List<Dept> list();

}
