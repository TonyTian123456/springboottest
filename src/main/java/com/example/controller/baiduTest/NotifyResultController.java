package com.example.controller.baiduTest;

import com.example.baiduTestAPI.Base64Util;
import com.example.domain.database2.NotifyResult;
import com.example.domain.request.NotifyResultRequest;
import com.example.domain.request.PageRequest;
import com.example.domain.response.NotifyResultResponseVo;
import com.example.entity.StdJson;
import com.example.exception.BizException;
import com.example.exception.ErrCode;
import com.example.intercepter.CheckSign;
import com.example.service.baidu.INotifyResultService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by cicada on 2019/11/22.
 */
@Controller
@RequestMapping("/notify")
public class NotifyResultController {

    private final Logger logger = LoggerFactory.getLogger(GroupController.class);
    private static final String CLASSNAME = "NotifyResultController";


    @Autowired
    private INotifyResultService notifyResultService;

    @RequestMapping("/result")
    @ResponseBody
    @CheckSign
    public StdJson notifyResult(@RequestBody NotifyResultRequest notifyResultRequest) throws ParseException {

        String logFlag = CLASSNAME + ".notifyResult";
        logger.info("[logFlag:{}][notifyResultRequest:{}]>>", logFlag, notifyResultRequest);
        if (null ==notifyResultRequest.getGroupId()){
            throw new BizException(ErrCode.USER_GROUP_ID_IS_EMPTY);
        }

        if (null ==notifyResultRequest.getUserId()){
            throw new BizException(ErrCode.USER_ID_IS_EMPTY);
        }

        if (null ==notifyResultRequest.getTimestamp()){
            throw new BizException(ErrCode.TIMESTAMP_IS_EMPTY);
        }
        if (null ==notifyResultRequest.getCameraId()){
            throw new BizException(ErrCode.CAMERA_ID_IS_EMPTY);
        }
        if (null ==notifyResultRequest.getScore()){
            throw new BizException(ErrCode.SCORE_IS_EMPTY);
        }
        if (null ==notifyResultRequest.getImage()){
            throw new BizException(ErrCode.IMAGE_IS_EMPTY);
        }
        String timeText="";
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss"); //设置格式
        if (null != notifyResultRequest.getTimestamp()){
            timeText=format.format(notifyResultRequest.getTimestamp());
        }
        String image = notifyResultRequest.getImage();
        Base64Util.base64ToImage(image,String.valueOf(timeText+"_"+notifyResultRequest.getUserId()+".jpg"));
        Boolean result = notifyResultService.AddNotifyResult(notifyResultRequest);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result,"Face recognition results recorded successfully");
    }

    @RequestMapping("/list")
    @ResponseBody
    @CrossOrigin
    public StdJson resultList(/*@RequestBody PageRequest pageRequest*/) throws ParseException {

        String logFlag = CLASSNAME + ".notifyResult";
        logger.info("[logFlag:{}]>>", logFlag);

        List<NotifyResultResponseVo> result = notifyResultService.queryList(/*pageRequest*/);
        logger.info("[logFlag:{}][result:{}]>>", logFlag, result);
        return StdJson.ok(result,"Face recognition results recorded successfully");
    }
}
