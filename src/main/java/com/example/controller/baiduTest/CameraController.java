package com.example.controller.baiduTest;

import com.alibaba.fastjson.JSONArray;
import com.example.domain.request.CameraRequest;
import com.example.entity.StdJson;
import com.example.exception.BizException;
import com.example.exception.ErrCode;
import com.example.service.baidu.IBaiduTestService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cicada on 2019/11/20.
 */
@Controller
@RequestMapping("/camera")
public class CameraController {

    private final Logger logger = LoggerFactory.getLogger(CameraController.class);
    private static final String CLASSNAME = "CameraController";


    String  filePath="/Users/cicada/Desktop/face_test";

    @Autowired
    private IBaiduTestService baiduTestService;

    @RequestMapping("/add")
    @ResponseBody
    public StdJson addCamera(@RequestBody CameraRequest cameraRequest ) throws Exception {
        String logFlag = CLASSNAME + ".addCamera";
        logger.info("[logFlag:{}][req:{}]>>", logFlag, cameraRequest);
        if (null ==cameraRequest.getGroupId()){
            throw new BizException(ErrCode.USER_GROUP_ID_IS_EMPTY);
        }
        if (StringUtils.isBlank(cameraRequest.getCameraId())){
            throw new BizException(ErrCode.USER_CAMERA_ID_IS_EMPTY);
        }
        Boolean result = baiduTestService.addCamera(cameraRequest);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public StdJson deleteCamera(@RequestBody CameraRequest cameraRequest ) throws Exception {
        String logFlag = CLASSNAME + ".deleteCamera";
        logger.info("[logFlag:{}][req:{}]>>", logFlag, cameraRequest);
        if (StringUtils.isBlank(cameraRequest.getCameraId())){
            throw new BizException(ErrCode.USER_CAMERA_ID_IS_EMPTY);
        }
        Boolean result = baiduTestService.deleteCamera(cameraRequest);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }

    @RequestMapping("/list")
    @ResponseBody
    public StdJson listCamera(@RequestBody CameraRequest cameraRequest ) throws Exception {
        String logFlag = CLASSNAME + ".listCamera";
        logger.info("[logFlag:{}][req:{}]>>", logFlag, cameraRequest);
        if (null ==cameraRequest.getGroupId()){
            throw new BizException(ErrCode.USER_GROUP_ID_IS_EMPTY);
        }
        JSONArray result = baiduTestService.listCamera(cameraRequest);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }

    @RequestMapping("/update")
    @ResponseBody
    public StdJson updateCamera(@RequestBody CameraRequest cameraRequest ) throws Exception {
        String logFlag = CLASSNAME + ".updateCamera";
        logger.info("[logFlag:{}][req:{}]>>", logFlag, cameraRequest);
        if (null ==cameraRequest.getGroupId()){
            throw new BizException(ErrCode.USER_GROUP_ID_IS_EMPTY);
        }
        if (StringUtils.isBlank(cameraRequest.getCameraId())){
            throw new BizException(ErrCode.USER_CAMERA_ID_IS_EMPTY);
        }
        Boolean result = baiduTestService.updateCameraGroup(cameraRequest);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }
}
