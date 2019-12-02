package com.example.controller.baiduTest;

import com.example.baiduTestAPI.Base64Util;
import com.example.baiduTestAPI.FileUtil;
import com.example.domain.request.NotifyResultRequest;
import com.example.entity.StdJson;
import com.example.exception.BizException;
import com.example.exception.ErrCode;
import com.example.intercepter.CheckSign;
import com.example.service.baidu.INotifyResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.ZipFile;

/**
 * Created by cicada on 2019/11/28.
 */
@Controller
@RequestMapping("/upload")
public class ImageTestController {

    private final Logger logger = LoggerFactory.getLogger(GroupController.class);
    private static final String CLASSNAME = "GroupController";

    String  filePath="/Users/cicada/Desktop/face_test";



    @RequestMapping("/image")
    @ResponseBody
//    @CheckSign
    public StdJson notifyResult(MultipartFile file ) throws IOException {

        File f = null;
        if(file.equals("")||file.getSize()<=0){
            file = null;
        }else{
            InputStream ins = file.getInputStream();
            f=new File(file.getOriginalFilename());
            FileUtil.inputStreamToFile(ins, f);
        }
        ZipFile zipFile = new ZipFile(f);
        HashMap<String,String> resultMap = new HashMap<String,String>();
        Base64Util.encode(FileUtil.readFileByBytes(filePath+ File.separator+file.getOriginalFilename()));
        return StdJson.ok(resultMap);
    }
}
