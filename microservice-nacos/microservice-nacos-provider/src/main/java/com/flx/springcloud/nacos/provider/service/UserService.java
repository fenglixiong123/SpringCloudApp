package com.flx.springcloud.nacos.provider.service;

import com.flx.springcloud.nacos.api.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 17:29
 */
@Service
public class UserService {

    private static Map<Long, User> userMap = new HashMap<>();

    static {
        userMap.put(1L,new User(1L,"jack",18,"打篮球01"));
        userMap.put(2L,new User(2L,"mary",20,"打篮球02"));
        userMap.put(3L,new User(3L,"tom",22,"打篮球03"));
        userMap.put(4L,new User(4L,"cat",24,"打篮球04"));
        userMap.put(5L,new User(5L,"jurcy",26,"打篮球05"));
    }

    public User findUserById(Long id){
        return userMap.get(id);
    }

    public List<User> findUserAll(){
        List<User> userList = new ArrayList<>();
        userMap.forEach((k,v)-> userList.add(v));
        return userList;
    }

}
