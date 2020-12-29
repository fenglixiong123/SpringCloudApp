package com.flx.springcloud.nacos.sdk.service;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.flx.springcloud.nacos.sdk.listener.ServiceListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/25 17:19
 * @Description: 服务注册与发现sdk
 * 1.获取服务所有实例
 * 2.获取健康或者不健康的实例
 * 3.获取一个健康的服务
 * 4.注册服务
 * 5.注销实例
 * 6.监听服务实例变化
 * 7.取消监听服务变化
 */
@Slf4j
@Service
public class NacosDiscoveryService {

    public final static String serverAddr = "";
    public final static String ip = "127.0.0.1";
    public final static int port = 8848;
    public final static String serviceName = "microservice-config";

    @Autowired
    private ServiceListener serviceListener;

    /**
     * 获取服务所有实例
     * List<Instance> getAllInstances(String serviceName)
     * List<Instance> getAllInstances(String serviceName, List<String> clusters)
     */
    public List<Instance> getAllInstance(){
        try {
            NamingService namingService = NamingFactory.createNamingService(serverAddr);
            List<Instance> allInstances = namingService.getAllInstances(serviceName);
            log.info("All instances : {}",allInstances);
            return allInstances;
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取健康或者不健康的实例
     * List<Instance> selectInstances(String serviceName, boolean healthy)
     * List<Instance> selectInstances(String serviceName, List<String> clusters, boolean healthy)
     */
    public List<Instance> getInstancesByStatus(){
        try {
            NamingService namingService = NamingFactory.createNamingService(serverAddr);
            List<Instance> healthInstances = namingService.selectInstances(serviceName,true);
            log.info("Healthy instances : {}",healthInstances);
            return healthInstances;
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取一个健康的服务
     * Instance selectOneHealthyInstance(String serviceName)
     * Instance selectOneHealthyInstance(String serviceName, List<String> clusters)
     */
    public Instance getOneHealthyInstance(){
        try {
            NamingService namingService = NamingFactory.createNamingService(serverAddr);
            Instance healthInstance = namingService.selectOneHealthyInstance(serviceName);
            log.info("Healthy instance : {}",healthInstance);
            return healthInstance;
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 注册服务
     * void registerInstance(String serviceName, String ip, int port)
     * void registerInstance(String serviceName, String ip, int port, String clusterName)
     * void registerInstance(String serviceName, Instance instance)
     */
    public void registerInstance(){
        try {
            NamingService namingService = NamingFactory.createNamingService(serverAddr);
            namingService.registerInstance(serviceName,ip,port,"cluster0");
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注销实例
     * void deregisterInstance(String serviceName, String ip, int port)
     * void deregisterInstance(String serviceName, String ip, int port, String clusterName)
     */
    public void deleteInstance(){
        try {
            NamingService namingService = NamingFactory.createNamingService(serverAddr);
            namingService.deregisterInstance(serviceName,ip,port,"cluster0");
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听服务实例变化
     * void subscribe(String serviceName, EventListener listener)
     * void subscribe(String serviceName, List<String> clusters, EventListener listener)
     */
    public void subscribeService(){
        try {
            NamingService namingService = NamingFactory.createNamingService(serverAddr);
            namingService.subscribe(serviceName,serviceListener);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取消监听服务变化
     * void unsubscribe(String serviceName, EventListener listener)
     * void unsubscribe(String serviceName, List<String> clusters, EventListener listener)
     */
    public void unSubscribeService(){
        try {
            NamingService namingService = NamingFactory.createNamingService(serverAddr);
            namingService.unsubscribe(serviceName,serviceListener);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

}
