package com.flx.springboot.utils;

import com.alibaba.fastjson.JSON;

/**
 * @Author: FengLiXiong
 * @Description:
 * @Date: Created in 2018/5/7 18:05
 */
public class CommonUtils {

    public static final String MICROSERVICE_PROVIDER_DEPT = "microservice-provider-dept";
    public static final String MICROSERVICE_PROVIDER_USER = "microservice-provider-user";

    public static String getJsonString(Object o){
        if(o==null){
            return null;
        }
        return JSON.toJSONString(o);
    }

}
