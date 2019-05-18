package com.flx.springboot;

import com.flx.balance.FiveRoundRobinStrategy;
import com.flx.balance.RibbonRandomStrategy;
import com.flx.springboot.utils.CommonUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * Ribbon是客户端的负载均衡
 * 重点：
 * 		客户端
 * 		负载均衡
 */
@EnableEurekaClient
@SpringBootApplication

//如果要自定义负载均衡策略
//而不是用ribbon默认提供的几种负载策略那么就添加RibbonClient注解
//反之就不用加这个注解，直接在@Configuration类中覆盖默认的IRule策略
//@RibbonClient(name = "microservice-dept",configuration = )
//注意：坑——这个自定义的配置类不能放@ComponentScan锁扫描的包以及子包下面
//否则我们定义这个配置类就会被所有的Ribbon客户端锁共享，达不到我们定制化的需求了
//如果有多个微服务采用不同的负载均衡策略，那么可以使用如下配置
@RibbonClients(value = {
		@RibbonClient(name = CommonUtils.MICROSERVICE_PROVIDER_DEPT,configuration = FiveRoundRobinStrategy.class),
		@RibbonClient(name = CommonUtils.MICROSERVICE_PROVIDER_USER,configuration = RibbonRandomStrategy.class)
})
public class ConsumerDeptRibbon80 {

	public static void main(String[] args) {

		SpringApplication.run(ConsumerDeptRibbon80.class, args);
		System.out.println("ConsumerDeptRibbon80 Running!");
	}
}
