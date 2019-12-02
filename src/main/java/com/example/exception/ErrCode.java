package com.example.exception;

/**
 * Created by cicada on 2019/8/21.
 */
public enum ErrCode implements ErrMsgEnum{

    SYSTEM_ERROR(3, "网络不给力，请稍后再试"),
    BIZ_PARAM_INVALID(1, "参数不合法"),
    TOKEN_STATUS_NO(8000,"无token，请重新登录"),
    TOKEN_STATUS_INVALID(8001,"token过期，请重新登录"),
    TOKEN_STATUS_ERROR(8002,"accessToken 错误"),
    SIGNATURE_STATUS_ERROR(8003,"签名验证异常异常"),


    USER_LOG_ERROR(8003,"用户名或密码不正确"),
    USER_INFO_IS_EMPTY(8004,"用户名或密码不能为空"),

    //百度对接测试
    USER_ID_IS_EMPTY(9000,"用户id不能为空"),
    USER_AGE_IS_EMPTY(9001,"用户年龄不能为空"),
    USER_GENDE_IS_EMPTY(9002,"用户性别不能为空"),
    USER_FACE_IMAGE_IS_EMPTY(9003,"用户人脸图片不能为空"),
    USER_GROUP_ID_IS_EMPTY(9004,"组id不能为空"),
    USER_GROUP_USER_ID_IS_EMPTY(9005,"组内用户id不能为空"),  //Timestamp
    USER_CAMERA_ID_IS_EMPTY(9004,"摄像机id不能为空"),
    TIMESTAMP_IS_EMPTY(9005,"Timestamp 不能为空"),
    CAMERA_ID_IS_EMPTY(9006,"抓拍摄像机id不能为空"),
    SCORE_IS_EMPTY(9007,"置信度分数（0-100）"),
    IMAGE_IS_EMPTY(9008,"BASE64编码的人脸图片不能为空"),
    ;

    private int errCode;

    private String errMsg;

    ErrCode(int code, String message) {
        this.errCode = code;
        this.errMsg = message;
    }

    @Override
    public int getErrCode() {
        return errCode;
    }


    @Override
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }


}
