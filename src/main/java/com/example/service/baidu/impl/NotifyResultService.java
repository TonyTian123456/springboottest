package com.example.service.baidu.impl;



import com.example.domain.database2.NotifyResult;
import com.example.domain.database2.NotifyResultExample;
import com.example.domain.request.NotifyResultRequest;
import com.example.domain.request.PageRequest;
import com.example.domain.response.NotifyResultResponseVo;
import com.example.domain.vo.NotifyResultVo;
import com.example.mapper.database2.NotifyResultMapper;
//import com.example.rabbitmq.config.Sender;
import com.example.service.baidu.INotifyResultService;
import com.example.utils.InnerBeanUtils;
import com.example.utils.ModelUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by cicada on 2019/11/25.
 */
@Service
public class NotifyResultService implements INotifyResultService {

    private final Logger logger = LoggerFactory.getLogger(NotifyResultService.class);
    private static final String CLASSNAME = "NotifyResultService";

    @Autowired
    private NotifyResultMapper notifyResultMapper;


    @Override
    public Boolean AddNotifyResult(NotifyResultRequest notifyResultRequest) throws ParseException {



        String logFlag = CLASSNAME + ".AddNotifyResult";
        String timeText="";
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
        if (null != notifyResultRequest.getTimestamp()){
             timeText=format.format(notifyResultRequest.getTimestamp());
        }
        NotifyResult notifyResult =new NotifyResult();
        InnerBeanUtils.copyPropertiesIgnoreNull(notifyResultRequest,notifyResult);
        ModelUtils.initBean(notifyResult,"Tester");
        logger.info("[logFlag:{}][notifyResult:{}]>>", logFlag, notifyResult.toString());
        NotifyResultVo notifyResultVo =new NotifyResultVo();
        InnerBeanUtils.copyPropertiesIgnoreNull(notifyResult,notifyResultVo);


        notifyResult.setPictureTime(format.parse(timeText));
        return notifyResultMapper.insertSelective(notifyResult)>0;
    }

    @Override
    public List<NotifyResultResponseVo> queryList(/*PageRequest pageRequest*/) {
        NotifyResultExample example = new NotifyResultExample();
        NotifyResultExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
//        criteria.andCreatorLike()
        List<NotifyResult> notifyResults = notifyResultMapper.selectByExample(example);
        long total = notifyResultMapper.countByExample(example);
        List<NotifyResultResponseVo> result = Lists.newArrayList();
        if (null != notifyResults && notifyResults.size()>0){
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (NotifyResult temp :notifyResults){
                NotifyResultResponseVo notifyResultResponseVo =new NotifyResultResponseVo();
                InnerBeanUtils.copyPropertiesIgnoreNull(temp,notifyResultResponseVo);
                notifyResultResponseVo.setPictureTime(format.format(temp.getPictureTime()));
                notifyResultResponseVo.setCreateTime(format.format(temp.getCreateTime()));
                result.add(notifyResultResponseVo);
            }
        }
//        PageInfo<NotifyResultResponseVo> notifyResultResponseVoPageInfo = new PageInfo<>(result);
//        notifyResultResponseVoPageInfo.setTotal(total);
        return result;
    }
}
