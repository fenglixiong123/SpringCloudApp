package com.flx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/3 17:19
 */
@EnableEurekaClient
@SpringBootApplication
public class ProviderDept8001 {

    public static void main(String[] args) {

        SpringApplication.run(ProviderDept8001.class,args);
        System.out.println("ProviderDept8001 Running!");
    }

}
