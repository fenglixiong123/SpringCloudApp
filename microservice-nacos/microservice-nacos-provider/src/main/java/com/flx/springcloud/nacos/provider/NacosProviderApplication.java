package com.flx.springcloud.nacos.provider;

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
public class NacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class, args);
        log.info(">>>>>>>>NacosProviderApplication started !");
    }

}
