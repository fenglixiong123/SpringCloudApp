package com.flx.app;

import com.flx.balance.FiveRoundRobinStrategy;
import com.flx.balance.RibbonRandomStrategy;
import com.flx.springboot.utils.CommonUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 18:55
 *
 * feign内部集成了Ribbon，只需要接口就可以优雅的实现了服务调用
 *
 * 服务熔断：由于某些原因使得服务出现了过载现象，为防止造成整个系统故障，从而采用的一种保护措施，所以很多地方把熔断亦称为过载保护。
 * 服务熔断和服务降级：
 *      服务熔断在服务器端的对异常方法进行处理返回一个可预期的结果，
 *      服务降级是在客户端的，当微服务不可用的时候进入服务降级处理返回一个可预期的结果
 *
 * 官方解释：
 *      服务熔断：一般是某个服务故障或者异常引起的，类似现实生活中的保险丝，当某个异常条件被触发时，直接熔断整个服务，而不是一直等到该服务调用超时
 *      服务降级：一般是从整体负荷考虑。就是当某个服务熔断之后，服务将不再被调用，此时此时客户端可以自己准备一个本地的fallback回调，返回一个缺省值，这样做虽然服务水平下降，但是好歹可用，比直接挂掉要强
 *
 * 仪表盘:
 *
 * 监控的服务必须添加actuator
 * 监控主页：http://localhost:1000/hystrix
 * 监控服务：http://localhost:8001/hystrix.stream
 *
 */
@EnableHystrixDashboard
@EnableCircuitBreaker //添加对熔断的支持
@EnableEurekaClient
@RibbonClients(value = {
        @RibbonClient(name = CommonUtils.MICROSERVICE_PROVIDER_DEPT,configuration = FiveRoundRobinStrategy.class),
        @RibbonClient(name = CommonUtils.MICROSERVICE_PROVIDER_USER,configuration = RibbonRandomStrategy.class)
})
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.flx.springboot"})
public class ConsumerApplication {
    public static void main(String[] args) {

        SpringApplication.run(ConsumerApplication.class,args);
        System.out.println("ConsumerDeptFeign80 Running!");

    }
}


/**
 *
 * //如果要自定义负载均衡策略
 * //而不是用ribbon默认提供的几种负载策略那么就添加RibbonClient注解
 * //反之就不用加这个注解，直接在@Configuration类中覆盖默认的IRule策略
 * //@RibbonClient(name = "microservice-dept",configuration = )
 * //注意：坑——这个自定义的配置类不能放@ComponentScan锁扫描的包以及子包下面
 * //否则我们定义这个配置类就会被所有的Ribbon客户端锁共享，达不到我们定制化的需求了
 * //如果有多个微服务采用不同的负载均衡策略，那么可以使用如下配置
 *
 */
