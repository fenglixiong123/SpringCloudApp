package com.flx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/8 15:58
 * 访问测试：
 * http://localhost:9101/microservice-provider-dept/dept/list
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulGateway9010 {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGateway9010.class,args);
        System.out.println("ZuulGateway9010 Running!");
    }

}
