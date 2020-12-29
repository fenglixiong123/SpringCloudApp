package com.flx.springcloud.nacos.sdk.listener;

import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/29 16:15
 * @Description: 监听服务实例变化
 */
@Slf4j
@Component
public class ServiceListener implements EventListener {

    public void onEvent(Event event) {
        if(event instanceof NamingEvent){
            NamingEvent namingEvent = (NamingEvent)event;
            log.info(namingEvent.getServiceName());
            log.info(namingEvent.getInstances().toString());
        }
    }

}
