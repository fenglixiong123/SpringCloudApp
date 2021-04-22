package com.flx.balance;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/4 20:29
 */
@Configuration
public class RibbonRandomStrategy{

    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }

}
