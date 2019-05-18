package com.flx.springboot.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/3 19:33
 */
@Configuration  //等同与SpringMVC.xml
public class ConfigBean {

    /**
     * 开启负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * Ribbon采用随机算法
     * @return
     */
//    @Bean
//    public IRule ribbonRandomRule(){
//        return new RetryRule();//在一定时间微服务不可用就抛弃此微服务
//        return new RandomRule();//随机策略访问微服务
//        return new RoundRobinRule();//轮训策略访问微服务
//    }

}
