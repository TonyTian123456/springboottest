package com.example.controller.baiduTest;

import com.alibaba.fastjson.JSONObject;
import com.example.baiduTestAPI.Base64Util;
import com.example.baiduTestAPI.FileUtil;
import com.example.entity.StdJson;
import com.example.domain.request.UserRequest;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by cicada on 2019/11/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String CLASSNAME = "UserController";

    String  filePath="/Users/cicada/Desktop/1204";

    @Autowired
    private IBaiduTestService baiduTestService;


    @RequestMapping("/add")
    @ResponseBody
    public StdJson addUser(UserRequest userRequest,MultipartFile file ) throws Exception {
        String logFlag = CLASSNAME + ".addUser";
        logger.info("[logFlag:{}][userRequest:{}][file:{}]>>", logFlag, userRequest,file);
        if (null ==userRequest.getUserId()){
            throw new BizException(ErrCode.USER_ID_IS_EMPTY);
        }
        if (null == userRequest.getAge()){
            throw new BizException(ErrCode.USER_AGE_IS_EMPTY);
        }
        if (StringUtils.isBlank(userRequest.getGender())){
            throw new BizException(ErrCode.USER_GENDE_IS_EMPTY);
        }
        if (null == file){
            throw new BizException(ErrCode.USER_FACE_IMAGE_IS_EMPTY);
        }
        userRequest.setFaceImageData(Base64Util.encode(FileUtil.readFileByBytes(filePath+ File.separator+file.getOriginalFilename())));
        if (!StringUtils.isBlank(userRequest.getFaceImageData())){
            String image = userRequest.getFaceImageData();
            Base64Util.base64ToImage(image,String.valueOf(userRequest.getUserId()+".jpg"));
        }
        JSONObject result = baiduTestService.addUser(userRequest);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public StdJson deleteUser(@RequestBody UserRequest userRequest ) {
        String logFlag = CLASSNAME + ".deleteUser";
        logger.info("[logFlag:{}][userRequest:{}]>>", logFlag, userRequest);
        if (null ==userRequest.getUserId()){
            throw new BizException(ErrCode.USER_ID_IS_EMPTY);
        }
        Boolean result = baiduTestService.deleteUser(userRequest);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }

    @RequestMapping("/update")
    @ResponseBody
    public StdJson updateUser(UserRequest userRequest,MultipartFile file  ) throws Exception {
        String logFlag = CLASSNAME + ".updateUser";
        logger.info("[logFlag:{}][userRequest:{}]>>", logFlag, userRequest);
        if (null ==userRequest.getUserId()){
            throw new BizException(ErrCode.USER_ID_IS_EMPTY);
        }
        if (null !=file){
            userRequest.setFaceImageData(Base64Util.encode(FileUtil.readFileByBytes(filePath+ File.separator+file.getOriginalFilename())));
        }
        Boolean result = baiduTestService.updateUser(userRequest);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }
}
