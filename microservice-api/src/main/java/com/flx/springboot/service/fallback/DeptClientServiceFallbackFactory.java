package com.flx.springboot.service.fallback;

import com.flx.springboot.entity.Dept;
import com.flx.springboot.service.IDeptClientService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/8 10:52
 * 服务降级，客户端层面的:
 * 客户端发现服务停止就会采用默认返回值
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<IDeptClientService>{

    private static final Logger logger = LoggerFactory.getLogger(DeptClientServiceFallbackFactory.class);

    @Override
    public IDeptClientService create(Throwable throwable) {
        return new IDeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                Dept dept = new Dept()
                        .setDeptno(id)
                        .setDname("该ID:"+id+"没有对应信息,Consumer客户端提供的降级信息，此刻服务端已经关闭！")
                        .setDb_source("服务降级");
                logger.info("Enter hystrix...return："+dept);
                return dept;
            }

            @Override
            public List<Dept> list() {
                return Arrays.asList(
                        new Dept().setDeptno(001L).setDname("001").setDb_source("default"),
                        new Dept().setDeptno(002L).setDname("002").setDb_source("default"),
                        new Dept().setDeptno(003L).setDname("003").setDb_source("default"));
            }
        };
    }
}
