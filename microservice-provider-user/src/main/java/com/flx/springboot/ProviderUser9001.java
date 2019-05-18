package com.flx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 16:11
 */
@EnableEurekaClient
@SpringBootApplication
public class ProviderUser9001 {

    public static void main(String[] args) {

        SpringApplication.run(ProviderUser9001.class,args);
        System.out.println("ProviderUser9001 Running!");

    }

}
