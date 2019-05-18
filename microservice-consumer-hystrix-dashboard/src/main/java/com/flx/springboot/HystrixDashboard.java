package com.flx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/8 14:49
 * 仪表盘
 * 监控的服务必须添加actuator
 * 监控主页：http://localhost:1000/hystrix
 * 监控服务：http://localhost:8001/hystrix.stream
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard.class,args);
        System.out.println("HystrixDashboard Running!");
    }

}
