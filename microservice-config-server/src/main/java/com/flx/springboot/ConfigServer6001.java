package com.flx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/8 17:56
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServer6001 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer6001.class,args);
        System.out.println("ConfigServer6001 Running!");
    }

}
