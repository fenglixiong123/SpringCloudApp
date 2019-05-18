package com.flx.balance;

import com.flx.balance.rules.FiveRoundRobinRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 15:48
 */
@Configuration
public class FiveRoundRobinStrategy {

    @Bean
    public IRule getFiveRoundRobinStrategy(){
        return new FiveRoundRobinRule();
    }

}
