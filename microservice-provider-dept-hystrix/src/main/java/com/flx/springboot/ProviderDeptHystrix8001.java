package com.flx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/3 17:19
 * 服务熔断：由于某些原因使得服务出现了过载现象，为防止造成整个系统故障，从而采用的一种保护措施，所以很多地方把熔断亦称为过载保护。
 * 服务熔断和服务降级：
 *      服务熔断在服务器端的对异常方法进行处理返回一个可预期的结果，
 *      服务降级是在客户端的，当微服务不可用的时候进入服务降级处理返回一个可预期的结果
 *
 * 官方解释：
 *      服务熔断：一般是某个服务故障或者异常引起的，类似现实生活中的保险丝，当某个异常条件被触发时，直接熔断整个服务，而不是一直等到该服务调用超时
 *      服务降级：一般是从整体负荷考虑。就是当某个服务熔断之后，服务将不再被调用，此时此时客户端可以自己准备一个本地的fallback回调，返回一个缺省值，这样做虽然服务水平下降，但是好歹可用，比直接挂掉要强
 */
@EnableCircuitBreaker //添加对熔断的支持
@EnableEurekaClient
@SpringBootApplication
public class ProviderDeptHystrix8001 {

    public static void main(String[] args) {

        SpringApplication.run(ProviderDeptHystrix8001.class,args);
        System.out.println("ProviderDeptHystrix8001 Running!");
    }

}
