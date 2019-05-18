package com.flx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 18:55
 *
 * feign内部集成了Ribbon，只需要接口就可以优雅的实现了服务调用
 *
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.flx.springboot"})
public class ConsumerDeptFeign80 {
    public static void main(String[] args) {

        SpringApplication.run(ConsumerDeptFeign80.class,args);
        System.out.println("ConsumerDeptFeign80 Running!");

    }
}
