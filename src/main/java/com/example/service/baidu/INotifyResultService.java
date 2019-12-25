package com.example.service.baidu;

import com.example.domain.database2.NotifyResult;
import com.example.domain.request.NotifyResultRequest;
import com.example.domain.request.PageRequest;
import com.example.domain.response.NotifyResultResponseVo;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;
import java.util.List;

/**
 * Created by cicada on 2019/11/25.
 */
public interface INotifyResultService {

    public Boolean AddNotifyResult(NotifyResultRequest notifyResultRequest) throws ParseException;

    public List<NotifyResultResponseVo> queryList(/*PageRequest pageRequest*/);
}
