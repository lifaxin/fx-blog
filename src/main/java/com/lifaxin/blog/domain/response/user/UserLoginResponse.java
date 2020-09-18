package com.lifaxin.blog.domain.response.user;

import lombok.Data;

/**
 * @Description 用户登录返回
 * @Author LiFaXin
 * @Date 2020/7/18 18:44
 * @Version
 **/
@Data
public class UserLoginResponse {

    /**
     * 登录后的token信息
     */
    private String token;
}
