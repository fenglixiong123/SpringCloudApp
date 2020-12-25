package com.flx.springcloud.nacos.sdk.service;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Fenglixiong
 * @Date: 2020/12/25 17:19
 * @Description: 服务注册与发现sdk
 */
@Slf4j
@Service
public class NacosDiscoveryService {

    public final static String serverAddr = "";
    public final static String ip = "127.0.0.1";
    public final static int port = 8848;
    public final static String serviceName = "microservice-config";


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



}
