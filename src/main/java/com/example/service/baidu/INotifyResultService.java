package com.example.service.baidu;

import com.example.domain.request.NotifyResultRequest;

import java.text.ParseException;

/**
 * Created by cicada on 2019/11/25.
 */
public interface INotifyResultService {

    public Boolean AddNotifyResult(NotifyResultRequest notifyResultRequest) throws ParseException;
}
