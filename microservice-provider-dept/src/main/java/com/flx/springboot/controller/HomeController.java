package com.flx.springboot.controller;

import com.flx.springboot.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/4 14:46
 */
@RestController
public class HomeController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/home/discovery",method = RequestMethod.GET)
    public Object discovery(){

        //获取所有的服务提供者
        List<String> services = discoveryClient.getServices();
        System.out.println("services:"+services);

        //获取指定服务提供者的实例详情
        List<ServiceInstance> instanceList = discoveryClient.getInstances(CommonUtils.MICROSERVICE_PROVIDER_DEPT);
        instanceList.forEach(instance->{
            String host = instance.getHost();
            int port = instance.getPort();
            String serviceId = instance.getServiceId();
            URI instanceUri = instance.getUri();
            System.out.println(serviceId+"\t"+host+"\t"+port+"\t"+instanceUri);
        });
        return this.discoveryClient;
    }

}
