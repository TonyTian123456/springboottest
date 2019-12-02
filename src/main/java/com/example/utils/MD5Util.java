package com.example.utils;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author wangwenbin
 * @date 2018-06-12
 */
public class MD5Util {

    public final static String AK = "pNx2XBmBse3e6vwhhEV5Iarp8qCvEOYS";
    public final static String SK = "rlWatNcv3VKfVyjgb0oAxcV3EIOjfAoU";

    // 测试方法
    public static void main(String[] args) throws ParseException {
        /*String pwd = AK+SK+"1574934619"+"1574934619"+"";
        System.out.println("加密前： " + pwd);
        System.err.println("加密后： " + MD5Util.getMD5(pwd));*/
        Long timestamp =1574935101776l;
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
        String timeText=format.format(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.parse(timeText));
    }

    /**
     * 生成md5
     *
     * @param message
     * @return
     */
    public static String getMD5(String message) {
        String md5str = "";
        try {
            // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 2 将消息变成byte数组
            byte[] input = message.getBytes();

            // 3 计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(input);

            // 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            md5str = bytesToHex(buff);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str.toLowerCase();
    }

    /**
     * 二进制转十六进制
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];

            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }
}
