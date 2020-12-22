package com.flx.springcloud.nacos.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/18 15:52
 * @Description:
 */
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.flx.springcloud.nacos.api.user.service")
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
        log.info(">>>>>>>>NacosConsumerApplication started !");
    }

}
