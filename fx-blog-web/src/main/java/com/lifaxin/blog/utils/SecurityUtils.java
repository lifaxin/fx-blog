package com.lifaxin.blog.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 密码工具
 *
 * @author LiFaXin
 * @date 2020/9/18 20:15
 **/
public class SecurityUtils {


    /**
     * MD5计算
     *
     * @param password  明文密码
     * @param salt      盐
     * @param hashTimes hash次数
     * @return java.lang.String
     * @author LiFaXin
     * @date 2020/9/18 20:16
     */
    public static String md5WithShaEncode(String password, String salt, int hashTimes){
        String waitEncodePassWord = password;
        // 随机hash次数
        for (int i = 0; i < hashTimes; i++){
            waitEncodePassWord = DigestUtils.sha1Hex(waitEncodePassWord);
        }
        // 计算MD5
        return DigestUtils.md5Hex(waitEncodePassWord + salt);
    }






}
