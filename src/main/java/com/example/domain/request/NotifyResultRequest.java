package com.example.domain.request;

import lombok.Data;

/**
 * Created by cicada on 2019/11/22.
 */
@Data
public class NotifyResultRequest {
    private Long groupId;

    private Long userId;

    private Long timestamp;

    private String cameraId;

    private Long score;

    private String image;
}
