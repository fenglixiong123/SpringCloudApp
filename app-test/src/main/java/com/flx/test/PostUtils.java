package com.flx.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;


/**
 * @author dujiang
 * @version V1.0
 * @Package com.lesson.api
 * @date 2020/3/23 15:30
 */
@Slf4j
public class PostUtils {

    public static void post(String url, String postBody) {
       log.info(given().contentType("application/json;charset=UTF-8").body(postBody).when().post(url).getBody().asString());
                //.body("message", equalTo("success"));
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        String source = FileUtils.read2Json("D:\\skuinfo.json");
        JSONObject jsonObject = FileUtils.getJsonObject(source);
        JSONArray jsonArray = FileUtils.getJsonArray(jsonObject);
        ListIterator<Object> iterator = jsonArray.listIterator();
        int countAdd=0;
        int countUpdate=0;
        Map map=new HashMap();
        int index=0;
//        for (int i = 0; i < 1500; i++) {
//            for (int j = 0; j <jsonArray.size() ; j++) {
//                String value= FileUtils.randomValue().replaceAll("-","a").substring(0,20);
//                if (!map.containsValue(value)){
//                    map.put(++index,value);
//                }
//                ((JSONObject)jsonArray.get(j)).put("matCode", value);
//            }
//
//            logger.info(">>>>>>>>>>>>>>>>>>第"+ ++countAdd+"次新增请求开始");
//            post("http://172.31.236.26/api/quicktron/basic/syncMatBasicInfos", FileUtils.getJsonString(jsonObject));
//            logger.info(">>>>>>>>>>>>>>>>>>第"+ countAdd+"次新增请求结束");
//        }

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j <499; j++) {
                JSONObject o = (JSONObject) jsonArray.get(j);
                o.put("matText",FileUtils.randomValue());
            }
//            while (iterator.hasNext()) {
//                ((JSONObject) iterator.next()).put("matText", FileUtils.randomValue());
//            }
            log.info(">>>>>>>>>>>>>>>>>>第"+ ++countUpdate+"次更新请求开始");
            post("http://172.31.236.26/api/quicktron/basic/syncMatBasicInfos", FileUtils.getJsonString(jsonObject));
            log.info(">>>>>>>>>>>>>>>>>>第"+ countUpdate+"次更新请求结束");
        }

       log.info("总sku个数："+index);
        long end =System.currentTimeMillis();
        log.info("总耗时："+(end-start)/(1000*60)+"分");

    }


}
