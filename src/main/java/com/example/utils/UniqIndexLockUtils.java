package com.example.utils;

public class UniqIndexLockUtils {

    /**
     * 生成当前时间戳的秒数
     * @return
     */
    public static Long createSeconds() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        System.out.println(UniqIndexLockUtils.createSeconds());
    }

}
