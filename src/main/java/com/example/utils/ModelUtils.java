package com.example.utils;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Date;

public class ModelUtils {
    // 数据库正常状态
    public static final int NORMAL_STATUS = 0;
    // 数据库删除状态
    public static final int DELETE_STATUS = -1;
    //超级管理员状态
    public static final int SUPER_STATUS = 2;

    public static final String DEFAULT_OPERATOR = "SYSTEM";

    // 根据项目约定，该操作的表都需要对应 creator／lastModifier／gmtCreate /gmtModify / status 字段
    public static void initBean(Object object, String operator) {
        if (object == null) {
            return;
        }

        if(StringUtils.isEmpty(operator)){
            initBean(object);
            return;
        }

        Field creator = ReflectionUtils.findField(object.getClass(), "creator");


        if (creator != null) {
            ReflectionUtils.makeAccessible(creator);
            ReflectionUtils.setField(creator, object, operator);
        }

        Field lastModifier = ReflectionUtils.findField(object.getClass(), "lastModifier");


        if (lastModifier != null) {
            ReflectionUtils.makeAccessible(lastModifier);
            ReflectionUtils.setField(lastModifier, object, operator);
        }

        // 兼容字段错误
        Field lastModifer = ReflectionUtils.findField(object.getClass(), "lastModifer");

        if(lastModifer != null) {
            ReflectionUtils.makeAccessible(lastModifer);
            ReflectionUtils.setField(lastModifer, object, operator);
        }

        Field gmtCreate = ReflectionUtils.findField(object.getClass(), "gmtCreate");


        Date now = new Date();

        if (gmtCreate != null) {
            ReflectionUtils.makeAccessible(gmtCreate);
            ReflectionUtils.setField(gmtCreate, object, now);
        }

        Field gmtModify = ReflectionUtils.findField(object.getClass(), "gmtModify");

        if (gmtModify != null) {
            ReflectionUtils.makeAccessible(gmtModify);
            ReflectionUtils.setField(gmtModify, object, now);
        }

        Field createTime = ReflectionUtils.findField(object.getClass(), "createTime");


        if (createTime != null) {
            ReflectionUtils.makeAccessible(createTime);
            ReflectionUtils.setField(createTime, object, now);
        }

        Field lastModifyTime = ReflectionUtils.findField(object.getClass(), "lastModifyTime");


        if (lastModifyTime != null) {
            ReflectionUtils.makeAccessible(lastModifyTime);
            ReflectionUtils.setField(lastModifyTime, object, now);
        }

        Field uniqIndexLock = ReflectionUtils.findField(object.getClass(), "uniqIndexLock");

        if (uniqIndexLock != null) {
            ReflectionUtils.makeAccessible(uniqIndexLock);
            ReflectionUtils.setField(uniqIndexLock, object, UniqIndexLockUtils.createSeconds());
        }

        Field status = ReflectionUtils.findField(object.getClass(), "status");


        if (status != null) {
            ReflectionUtils.makeAccessible(status);
            ReflectionUtils.setField(status, object, NORMAL_STATUS);
        }
    }

    public static void initBean(Object object) {
//        if(UserContext.getUserHolder() != null){
//            initBean(object, UserContext.getUserHolder().getUserId());
//        }else{
            //通过RPC调用的接口，没有上下文,直接同更新一样，使用10000
            initBean(object, "10000");
//        }

    }

    public static void updateBean(Object object) {
//        if (UserContext.getUserHolder() != null) {
//            updateBean(object, UserContext.getUserHolder().getUserId());
//        }else {
            updateBean(object, "10000");
//        }
    }


    public static void updateBean(Object object, String operator) {
        if (object == null) {
            return;
        }

        if (StringUtils.isEmpty(operator)){
            updateBean(object);
            return;
        }

        Field lastModifier = ReflectionUtils.findField(object.getClass(), "lastModifier");


        if (lastModifier != null) {
            ReflectionUtils.makeAccessible(lastModifier);
            ReflectionUtils.setField(lastModifier, object, operator);
        }

        // 兼容字段错误
        Field lastModifer = ReflectionUtils.findField(object.getClass(), "lastModifer");

        if(lastModifer != null) {
            ReflectionUtils.makeAccessible(lastModifer);
            ReflectionUtils.setField(lastModifer, object, operator);
        }

        Date now = new Date();

        Field gmtModify = ReflectionUtils.findField(object.getClass(), "gmtModify");


        if (gmtModify != null) {
            ReflectionUtils.makeAccessible(gmtModify);
            ReflectionUtils.setField(gmtModify, object, now);
        }


        Field lastModifyTime = ReflectionUtils.findField(object.getClass(), "lastModifyTime");


        if (lastModifyTime != null) {
            ReflectionUtils.makeAccessible(lastModifyTime);
            ReflectionUtils.setField(lastModifyTime, object, now);
        }

    }

    public static void deleteBean(Object object, String operator) {
        updateBean(object,operator);

        Field status = ReflectionUtils.findField(object.getClass(),"status");

        if(status != null) {
            ReflectionUtils.makeAccessible(status);
            ReflectionUtils.setField(status, object, DELETE_STATUS);
        }

        Field uniqIndexLock = ReflectionUtils.findField(object.getClass(),"uniqIndexLock");
        if(uniqIndexLock != null) {
            ReflectionUtils.makeAccessible(uniqIndexLock);
            ReflectionUtils.setField(uniqIndexLock, object, UniqIndexLockUtils.createSeconds());
        }
    }

    public static void deleteBean(Object object) {
        updateBean(object,DEFAULT_OPERATOR);

        Field status = ReflectionUtils.findField(object.getClass(),"status");

        if(status != null) {
            ReflectionUtils.makeAccessible(status);
            ReflectionUtils.setField(status, object, DELETE_STATUS);
        }
    }
}
