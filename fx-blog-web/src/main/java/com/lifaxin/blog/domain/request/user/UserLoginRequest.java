package com.lifaxin.blog.domain.request.user;

import lombok.Data;

/**
 * @Description 用户登录请求
 * @Author LiFaXin
 * @Date 2020/7/18 18:39
 * @Version
 **/
@Data
public class UserLoginRequest {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String verificationCode;
}
