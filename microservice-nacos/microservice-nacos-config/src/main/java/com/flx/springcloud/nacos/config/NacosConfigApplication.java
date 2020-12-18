package com.flx.springcloud.nacos.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/18 15:52
 * @Description:
 */
@Slf4j
@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class, args);
        log.info(">>>>>>>>NacosConfigApplication started !");
    }

}
