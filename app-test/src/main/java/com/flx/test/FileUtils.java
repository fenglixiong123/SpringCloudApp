package com.flx.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.Random;
import java.util.UUID;

/**
 * @author dujiang
 * @version V1.0
 * @Package com.lesson.api
 * @date 2020/3/23 14:37
 */
public class FileUtils {
    //C:\\Users\\Think\\DeskTop\\skuinfo.json
    public static String read2Json(String jsonPath) {
        StringBuilder sb = new StringBuilder();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(new File(jsonPath));
            br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String line = read2Json("C:\\Users\\Think\\DeskTop\\skuinfo.json");
////        string2JsonArray(line);
////        System.out.println(getJsonString(line));
////        System.out.println(randomValue());
//        JSONObject jsonObject = getJsonObject(line);
//        JSONArray jsonArray = getJsonArray(jsonObject);
//        modifyField((JSONObject) jsonArray.get(0),"matCode",randomValue());
//        System.out.println(getJsonString(jsonObject));
        System.out.println(randomInt());
    }

    public static JSONObject getJsonObject(String json){
        return (JSONObject) JSON.parse(json);
    }
    public static JSONArray getJsonArray(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        return jsonArray;
    }
    public static String getJsonString(JSONObject object){
        return JSON.toJSONString(object);
    }

    public static JSONObject modifyField(JSONObject source,String key ,Object value){
        return source.fluentPut(key,value);
    }

    public static String randomValue(){
       return UUID.randomUUID().toString();
    }

    public static int randomInt(){
        return new Random().nextInt(100);
    }


}
