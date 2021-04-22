package com.flx.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 16:11
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProviderApplication.class,args);
        System.out.println("ProviderUser9001 Running!");

    }

}
