package com.example.domain.response;

import lombok.Data;

import java.util.Date;

/**
 * Created by cicada on 2019/12/3.
 */
@Data
public class NotifyResultResponseVo {


    private Long id;

    private Long groupId;

    private Long userId;

    private String pictureTime;

    private String cameraId;

    private Long score;

    private String createTime;

}
