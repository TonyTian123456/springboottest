package com.example.service.baidu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.baiduTestAPI.GsonUtils;
import com.example.domain.request.CameraRequest;
import com.example.domain.request.GroupRequest;
import com.example.domain.request.UserRequest;
import com.example.utils.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cicada on 2019/11/25.
 */
public interface IBaiduTestService {
    public  Boolean addGroup(GroupRequest groupRequest);

    public  Boolean deleteGroup(GroupRequest groupRequest);

    public JSONArray listGroup();

    public  Boolean addGroupUser(GroupRequest groupRequest);

    public  Boolean deleteGroupUser(GroupRequest groupRequest);

    public  JSONArray listGroupUser(GroupRequest groupRequest);


    public  JSONObject addUser(UserRequest userRequest);

    public  Boolean deleteUser(UserRequest userRequest);

    public  Boolean updateUser(UserRequest userRequest);


    public  Boolean addCamera(CameraRequest cameraRequest);

    public  Boolean deleteCamera(CameraRequest cameraRequest);

    public  JSONArray listCamera(CameraRequest cameraRequest);


    public  Boolean updateCameraGroup(CameraRequest cameraRequest);
}
