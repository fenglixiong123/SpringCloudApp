package com.flx.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Fenglixiong
 * @Date: 2019/8/21 11:09
 * @Description:
 */
@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
        log.info("GateWayApplication start...");
    }

}
