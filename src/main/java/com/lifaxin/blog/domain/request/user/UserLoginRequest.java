package com.lifaxin.blog.domain.request.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 用户登录请求
 * @Author LiFaXin
 * @Date 2020/7/18 18:39
 * @Version
 **/
@Data
public class UserLoginRequest {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;
}
