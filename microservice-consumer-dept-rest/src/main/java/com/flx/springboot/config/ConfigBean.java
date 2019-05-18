package com.flx.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/3 19:33
 */
@Configuration  //等同与SpringMVC.xml
public class ConfigBean {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
