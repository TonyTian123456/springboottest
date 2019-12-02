package com.example.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Component
@Data
public class NotifyResultVo  implements Serializable{

    private Long id;


    private Long groupId;


    private Long userId;


    private Long timestamp;


    private String creator;


    private String lastModifier;


    private Date createTime;


    private Date lastModifyTime;

    private Integer status;


    private Long uniqIndexLock;

}