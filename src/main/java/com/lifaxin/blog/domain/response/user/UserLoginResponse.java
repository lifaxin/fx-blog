package com.lifaxin.blog.domain.response.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 用户登录返回
 * @Author LiFaXin
 * @Date 2020/7/18 18:44
 * @Version
 **/
@Data
public class UserLoginResponse {
    @ApiModelProperty("Token")
    private String token;
}
