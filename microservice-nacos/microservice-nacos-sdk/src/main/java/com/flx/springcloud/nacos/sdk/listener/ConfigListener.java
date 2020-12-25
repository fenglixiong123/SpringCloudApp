package com.flx.springcloud.nacos.sdk.listener;

import com.alibaba.nacos.api.config.listener.Listener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/25 17:07
 * @Description:
 */
@Slf4j
@Component
public class ConfigListener implements Listener {

    public Executor getExecutor() {
        return null;
    }

    public void receiveConfigInfo(String s) {
        log.info("receive config:{}",s);
    }
}
