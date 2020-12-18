package com.flx.springcloud.nacos.consumer;

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
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
        log.info(">>>>>>>>NacosConsumerApplication started !");
    }

}
