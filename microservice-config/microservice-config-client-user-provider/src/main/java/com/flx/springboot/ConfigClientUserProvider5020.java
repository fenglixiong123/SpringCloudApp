package com.flx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/8 20:33
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientUserProvider5020 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientUserProvider5020.class,args);
        System.out.println("ConfigClientUserProvider5020 Running!");
    }

}
