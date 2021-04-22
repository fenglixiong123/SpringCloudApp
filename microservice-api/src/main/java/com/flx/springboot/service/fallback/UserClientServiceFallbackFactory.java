package com.flx.springboot.service.fallback;

import com.flx.springboot.entity.User;
import com.flx.springboot.service.IUserClientService;
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
public class UserClientServiceFallbackFactory implements FallbackFactory<IUserClientService>{

    private static final Logger logger = LoggerFactory.getLogger(UserClientServiceFallbackFactory.class);

    @Override
    public IUserClientService create(Throwable throwable) {
        return new IUserClientService() {
            @Override
            public Object getUser(Long id) {
                User dept = new User()
                        .setId(id)
                        .setName("该ID:"+id+"没有对应信息,Consumer客户端提供的降级信息，此刻服务端已经关闭！")
                        .setHobby("服务降级");
                logger.info("Enter hystrix...return："+dept);
                return dept;
            }

            @Override
            public List<User> listUser() {
                return Arrays.asList(
                        new User().setId(001L).setName("001").setHobby("default"),
                        new User().setId(002L).setName("002").setHobby("default"),
                        new User().setId(003L).setName("003").setHobby("default"));
            }
        };
    }
}
