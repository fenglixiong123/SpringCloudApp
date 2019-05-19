package com.flx.springboot.service;

import com.flx.springboot.entity.User;
import com.flx.springboot.utils.CommonUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 19:42
 */
@FeignClient(value = CommonUtils.MICROSERVICE_PROVIDER_USER)
public interface IUserClientService {

    @RequestMapping(value = "/user/get/{id}",method = RequestMethod.GET)
    Object getUser(@PathVariable("id") Long id);

    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    List<User> listUser();

}
