package com.flx.springboot.controller;

import com.flx.springboot.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/4 19:53
 */
@RestController
@RequestMapping("/ribbon")
public class DiscoveryController {

    @Autowired
    private LoadBalancerClient balancerClient;

    @RequestMapping(value = "/balance/dept",method = RequestMethod.GET)
    public Object loadBalanceStrategyForDept(){

        ServiceInstance instance = balancerClient.choose(CommonUtils.MICROSERVICE_PROVIDER_DEPT);

        return showInstanceInfo(instance);
    }


    @RequestMapping(value = "/balance/user",method = RequestMethod.GET)
    public Object loadBalanceStrategyForUser(){

        ServiceInstance instance = balancerClient.choose(CommonUtils.MICROSERVICE_PROVIDER_USER);

        return showInstanceInfo(instance);
    }

    /**
     * 显示instance信息
     * @param instance
     * @return
     */
    private String showInstanceInfo(ServiceInstance instance) {
        String host = instance.getHost();
        int port = instance.getPort();
        String serviceId = instance.getServiceId();
        URI instanceUri = instance.getUri();
        String info = serviceId+"\t"+host+"\t"+port+"\t"+instanceUri;
        System.out.println(info);
        return info;
    }
}
