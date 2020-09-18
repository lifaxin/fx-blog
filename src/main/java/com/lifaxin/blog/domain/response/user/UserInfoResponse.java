package com.lifaxin.blog.domain.response.user;

import lombok.Data;

import java.util.List;

/**
 * @Description 用户信息
 * @Author LiFaXin
 * @Date 2020/7/18 18:48
 * @Version
 **/
@Data
public class UserInfoResponse {

    /**
     * 简介
     */
    private String introduction;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 用户名
     */
    private String name;

    /**
     * 角色
     */
    private List<String> roles;
}
