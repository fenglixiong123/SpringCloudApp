package com.flx.springcloud.nacos.sdk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/24 16:00
 * @Description:
 */
@Slf4j
@SpringBootApplication
public class NacosSdkApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSdkApplication.class,args);
        log.info("NacosSdkApplication started ...");
    }

}
