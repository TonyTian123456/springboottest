package com.example.domain.request;

import lombok.Data;

import java.security.Principal;

/**
 * Created by cicada on 2019/11/20.
 */
@Data
public class UserRequest {

    private  Long userId;

    private Integer age;

    private String gender;

    private String faceImageData;
}
