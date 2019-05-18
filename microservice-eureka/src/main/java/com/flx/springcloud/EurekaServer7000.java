package com.flx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/3 21:04
 */
@EnableEurekaServer  //表示注册中心
@SpringBootApplication
public class EurekaServer7000 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServer7000.class,args);
        System.out.println(">>>>>>>>>>Eureka7000 Server Running!");
    }

}
