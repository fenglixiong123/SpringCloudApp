package com.flx.springcloud;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Fenglixiong
 * @Date: 2019/8/27 12:08
 * @Description:
 */
@Slf4j
@EnableAdminServer   //开启监控平台
@EnableEurekaClient
@SpringBootApplication
public class BootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAdminApplication.class,args);
        log.info("BootAdminApplication Start...");
    }

}
