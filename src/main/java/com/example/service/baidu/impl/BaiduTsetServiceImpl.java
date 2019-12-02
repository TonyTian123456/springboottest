package com.example.service.baidu.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.baiduTestAPI.GsonUtils;
import com.example.domain.request.CameraRequest;
import com.example.domain.request.GroupRequest;
import com.example.domain.request.UserRequest;
import com.example.service.baidu.IBaiduTestService;
import com.example.utils.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cicada on 2019/11/21.
 */
@Service
public class BaiduTsetServiceImpl implements IBaiduTestService {

    private String baseUrl ="http://xteam.baidu.com/api/service/chanming/face";

    @Override
    public  Boolean addGroup(GroupRequest groupRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/group/add";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("groupId", groupRequest.getGroupId());

            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return Boolean.FALSE;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            return Integer.valueOf(parseResult.get("code").toString())==0?Boolean.TRUE:Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    @Override
    public  Boolean deleteGroup(GroupRequest groupRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/group/delete";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("groupId", groupRequest.getGroupId());


            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return Boolean.FALSE;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            return Integer.valueOf(parseResult.get("code").toString())==0?Boolean.TRUE:Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    @Override
    public  JSONArray listGroup() {
        // 请求url
        String url = baseUrl+"/api/v1/group/list";
        try {
            Map<String, Object> map = new HashMap<String, Object>();


            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return null;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            JSONArray res=null;
            if (Integer.valueOf(parseResult.get("code").toString())==0){
                res = parseResult.getJSONArray("data");
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  Boolean addGroupUser(GroupRequest groupRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/group/addUser";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", groupRequest.getUserId());
            map.put("groupId", groupRequest.getGroupId());
            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return Boolean.FALSE;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            return Integer.valueOf(parseResult.get("code").toString())==0?Boolean.TRUE:Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    @Override
    public  Boolean deleteGroupUser(GroupRequest groupRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/group/deleteUser";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", groupRequest.getUserId());
            map.put("groupId", groupRequest.getGroupId());
            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return Boolean.FALSE;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            return Integer.valueOf(parseResult.get("code").toString())==0?Boolean.TRUE:Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    @Override
    public  JSONArray listGroupUser(GroupRequest groupRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/group/listUser";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("groupId", groupRequest.getGroupId());
            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return null;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            JSONArray res=null;
            if (Integer.valueOf(parseResult.get("code").toString())==0){
                res = parseResult.getJSONArray("data");
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public  JSONObject addUser(UserRequest userRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/user/add";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("faceImageData", userRequest.getFaceImageData());
            map.put("userId", userRequest.getUserId());
            map.put("age", userRequest.getAge());
            map.put("gender", userRequest.getGender());

            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return null;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            if (Integer.valueOf(parseResult.get("code").toString())==0){
                return parseResult;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  Boolean deleteUser(UserRequest userRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/database1/delete";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", 1324009);

            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return Boolean.FALSE;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            return Integer.valueOf(parseResult.get("code").toString())==0?Boolean.TRUE:Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    @Override
    public  Boolean updateUser(UserRequest userRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/database1/update";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("faceImageData", userRequest.getFaceImageData());
            map.put("userId", userRequest.getUserId());
            map.put("age", userRequest.getAge());
            map.put("gender", userRequest.getGender());

            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return Boolean.FALSE;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            return Integer.valueOf(parseResult.get("code").toString())==0?Boolean.TRUE:Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }


    @Override
    public  Boolean addCamera(CameraRequest cameraRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/camera/add";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("groupId", cameraRequest.getGroupId());
            map.put("cameraId", cameraRequest.getCameraId());

            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return Boolean.FALSE;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            return Integer.valueOf(parseResult.get("code").toString())==0?Boolean.TRUE:Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    @Override
    public  Boolean deleteCamera(CameraRequest cameraRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/camera/delete";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("cameraId", cameraRequest.getCameraId());

            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return Boolean.FALSE;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            return Integer.valueOf(parseResult.get("code").toString())==0?Boolean.TRUE:Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    @Override
    public  JSONArray listCamera(CameraRequest cameraRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/camera/list";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("groupId", cameraRequest.getGroupId());
            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return null;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            JSONArray res=null;
            if (Integer.valueOf(parseResult.get("code").toString())==0){
                res = parseResult.getJSONArray("data");
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public  Boolean updateCameraGroup(CameraRequest cameraRequest) {
        // 请求url
        String url = baseUrl+"/api/v1/camera/update";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("groupId", cameraRequest.getGroupId());
            map.put("cameraId", cameraRequest.getCameraId());

            String paramJson = GsonUtils.toJson(map);

            String result = HttpClientUtil.sendJsonStr(url,paramJson);
            if (StringUtils.isBlank(result)){
                return Boolean.FALSE;
            }
            JSONObject parseResult = JSONObject.parseObject(result);
            return Integer.valueOf(parseResult.get("code").toString())==0?Boolean.TRUE:Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }



}
