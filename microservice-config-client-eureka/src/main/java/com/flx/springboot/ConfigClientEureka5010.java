package com.flx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/8 20:08
 *
 * 本次Config实战项目是eureka配置从configServer中获取
 * client-user-provider
 * client-user-consumer
 * 两个都是从git上面直接拉取配置文件然后进行处理
 */
@EnableEurekaServer
@SpringBootApplication
public class ConfigClientEureka5010 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientEureka5010.class,args);
        System.out.println("ConfigClientEureka5010 Running!");
    }

}
