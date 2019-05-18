package com.flx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/8 19:04
 *
 * bootstrap.yml
 * application.yml
 *
 * SpringCloud会创建一个BootStrapContext，作为Spring应用的ApplicationContext的父上下文。
 * 初始化的时候Bootstrap Context负责从外部加载配置并解析配置。这两个上下文共享一个从外部获取的
 * Environment，前者具有高优先级，默认情况下他们不会被本地覆盖
 *
 * 测试通过eureka连接config server读取配置文件
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClient5001 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient5001.class,args);
        System.out.println("ConfigClient5001 Running!");
    }
}
