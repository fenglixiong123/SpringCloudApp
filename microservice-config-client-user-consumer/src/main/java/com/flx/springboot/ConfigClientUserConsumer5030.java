package com.flx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/8 20:51
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientUserConsumer5030 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientUserConsumer5030.class,args);
        System.out.println("ConfigClientUserConsumer5030 Running!");
    }

}
