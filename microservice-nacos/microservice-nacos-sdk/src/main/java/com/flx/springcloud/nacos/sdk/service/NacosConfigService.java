package com.flx.springcloud.nacos.sdk.service;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.flx.springcloud.nacos.sdk.listener.ConfigListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/25 16:39
 * @Description: 配置sdk
 */
@Slf4j
@Service
public class NacosConfigService {

    public final static String serverAddr = "";
    public final static String group = "fenglixiong";
    public final static String dataId = "";

    @Autowired
    private ConfigListener configListener;

    /**
     * 获取配置接口
     * String getConfig(String dataId, String group, long timeoutMs)
     */
    public String getConfig(){

        try {
            Properties properties = new Properties();
            properties.put("serverAddr",serverAddr);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String serverStatus = configService.getServerStatus();
            log.info("serverStatus = {}",serverStatus);
            String content = configService.getConfig(dataId, group, 3000L);
            log.info("content = {}",content);
            return content;
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 发布配置
     * public boolean publishConfig(String dataId, String group, String content)
     */
    public boolean pulishConfig(){
        try {
            ConfigService configService = NacosFactory.createConfigService(serverAddr);
            boolean isPublished = configService.publishConfig(dataId,group,"content");
            log.info("isPublished = {}",isPublished);
            return isPublished;
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除配置
     * boolean removeConfig(String dataId, String group)
     */
    public boolean deleteConfig(){
        try {
            ConfigService configService = NacosFactory.createConfigService(serverAddr);
            boolean isDeleted = configService.removeConfig(dataId, group);
            log.info("isDeleted = {}",isDeleted);
            return isDeleted;
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 添加配置监听功能
     * void addListener(String dataId, String group, Listener listener)
     */
    public void addConfigListener(){
        try {
            ConfigService configService = NacosFactory.createConfigService(serverAddr);
            String content = configService.getConfig(dataId, group, 3000L);
            log.info("content = {}",content);
            configService.addListener(dataId, group, configListener);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除监听
     * void removeListener(String dataId, String group, Listener listener)
     */
    public void deleteConfigListener(){
        try {
            ConfigService configService = NacosFactory.createConfigService(serverAddr);
            configService.removeListener(dataId,group,configListener);
            log.info("removed listener!");
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }



}
