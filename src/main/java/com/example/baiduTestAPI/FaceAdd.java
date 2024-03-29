package com.example.baiduTestAPI;


import org.springframework.stereotype.Service;

import java.util.*;

/**
* 人脸注册
*/
@Service
public class FaceAdd {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public  String add(String filePath,String accessToken) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/database1/add";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", Base64Util.encode(FileUtil.readFileByBytes(filePath)));
            map.put("group_id", "chanming_test_01");
            map.put("user_id", "chanming_test_uid_01");
            map.put("user_info", "abc");
            map.put("liveness_control", "NORMAL");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
//            String accessToken1 = "24.93552f9a6891d4ed236895240eec9915.2592000.1575616154.282335-17663176";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public  String getList(String accessToken) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/face/getlist";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("image", Base64Util.encode(FileUtil.readFileByBytes("/Users/cicada/Desktop/WechatIMG2.jpeg")));
            map.put("group_id", "chanming_test_01");
            map.put("user_id", "chanming_test_uid_01");
//            map.put("user_info", "abc");
//            map.put("liveness_control", "NORMAL");
//            map.put("image_type", "BASE64");
//            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
//            String accessToken1 = "24.93552f9a6891d4ed236895240eec9915.2592000.1575616154.282335-17663176";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  String search(String filePath,String accessToken) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", Base64Util.encode(FileUtil.readFileByBytes(filePath)));
            map.put("group_id_list", "chanming_test_01");
            map.put("user_id", "chanming_test_uid_01");
            map.put("user_info", "abc");
            map.put("liveness_control", "NORMAL");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
//            String accessToken1 = "24.93552f9a6891d4ed236895240eec9915.2592000.1575616154.282335-17663176";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
//        FaceAdd.getList();
    }
}