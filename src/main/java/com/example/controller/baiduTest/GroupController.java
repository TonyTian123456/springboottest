package com.example.controller.baiduTest;


import com.alibaba.fastjson.JSONArray;
import com.example.domain.request.GroupRequest;
import com.example.entity.StdJson;
import com.example.exception.BizException;
import com.example.exception.ErrCode;
import com.example.service.baidu.IBaiduTestService;
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
@RequestMapping("/group")
public class GroupController {


    private final Logger logger = LoggerFactory.getLogger(GroupController.class);
    private static final String CLASSNAME = "GroupController";

    private String  accessToken = "24.e7a8174ba7c2e30462c4d8ff912bf43e.2592000.1575702726.282335-17663176";

    String  filePath="/Users/cicada/Desktop/face_test";

    @Autowired
    private IBaiduTestService baiduTestService;

    @RequestMapping("/add")
    @ResponseBody
    public StdJson addGroup(@RequestBody GroupRequest groupRequest ) {
        String logFlag = CLASSNAME + ".addGroup";
        logger.info("[logFlag:{}][groupRequest:{}]>>", logFlag, groupRequest);
        if (null ==groupRequest.getGroupId()){
            throw new BizException(ErrCode.USER_GROUP_ID_IS_EMPTY);
        }
        Boolean result = baiduTestService.addGroup(groupRequest);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public StdJson deleteGroup(@RequestBody GroupRequest groupRequest ) {
        String logFlag = CLASSNAME + ".deleteGroup";
        logger.info("[logFlag:{}][groupRequest:{}]>>", logFlag, groupRequest);
        if (null ==groupRequest.getGroupId()){
            throw new BizException(ErrCode.USER_GROUP_ID_IS_EMPTY);
        }
        Boolean result = baiduTestService.deleteGroup(groupRequest);

        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }

    @RequestMapping("/list")
    @ResponseBody
    public StdJson listGroup() throws Exception {
        String logFlag = CLASSNAME + ".listGroup";
        logger.info("[logFlag:{}]>>", logFlag);
        JSONArray result = baiduTestService.listGroup();
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public StdJson addUser(@RequestBody GroupRequest groupRequest ) {
        String logFlag = CLASSNAME + ".listGroup";
        logger.info("[logFlag:{}][groupRequest:{}]>>", logFlag, groupRequest);
        if (null ==groupRequest.getGroupId()){
            throw new BizException(ErrCode.USER_GROUP_ID_IS_EMPTY);
        }
        if (null ==groupRequest.getUserId()){
            throw new BizException(ErrCode.USER_GROUP_USER_ID_IS_EMPTY);
        }
        Boolean result = baiduTestService.addGroupUser(groupRequest);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public StdJson deleteUser(@RequestBody GroupRequest groupRequest ){
        String logFlag = CLASSNAME + ".listGroup";
        logger.info("[logFlag:{}][groupRequest:{}]>>", logFlag, groupRequest);
        if (null ==groupRequest.getGroupId()){
            throw new BizException(ErrCode.USER_GROUP_ID_IS_EMPTY);
        }
        if (null ==groupRequest.getUserId()){
            throw new BizException(ErrCode.USER_GROUP_USER_ID_IS_EMPTY);
        }
        Boolean result = baiduTestService.deleteGroupUser(groupRequest);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result);
    }

    @RequestMapping("/listUser")
    @ResponseBody
    public StdJson listUser(@RequestBody GroupRequest groupRequest ){
        String logFlag = CLASSNAME + ".listGroup";
        logger.info("[logFlag:{}][groupRequest:{}]>>", logFlag, groupRequest);
        if (null ==groupRequest.getGroupId()){
            throw new BizException(ErrCode.USER_GROUP_ID_IS_EMPTY);
        }
        JSONArray array = baiduTestService.listGroupUser(groupRequest);
        logger.info("[logFlag:{}][array:{}]>>", logFlag, array);
        return StdJson.ok(array);
    }
}
