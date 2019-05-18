package com.flx.balance.rules;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @Author: FengLiXiong
 * @Description: 自定义每五次轮询一次
 * @Date: Created in 2018/5/4 20:49
 */
public class FiveRoundRobinRule extends AbstractLoadBalancerRule {

    //总共调用次数
    private int total = 0;
    //当前微服务机器
    private int currentIndex = 0;

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

//                int index = this.rand.nextInt(serverCount);
//                server = (Server)upList.get(index);
//----------------------------------------------------------------------------
                if(total<5){
                    server = upList.get(currentIndex);
                    total ++;
                }else {
                    total = 0;
                    currentIndex ++;
                    if(currentIndex>=upList.size()){
                        currentIndex = 0;
                    }
                }
//----------------------------------------------------------------------------
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}

