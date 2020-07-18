package com.lifaxin.blog.controller;

import com.lifaxin.blog.domain.request.user.UserLoginRequest;
import com.lifaxin.blog.domain.response.common.CommonResponse;
import com.lifaxin.blog.domain.response.user.UserInfoResponse;
import com.lifaxin.blog.domain.response.user.UserLoginResponse;
import com.lifaxin.blog.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @Description 用户相关信息
 * @Author LiFaXin
 * @Date 2020/7/18 18:38
 * @Version
 **/
@Api("用户相关管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Mono<CommonResponse<UserLoginResponse>> login(@RequestBody UserLoginRequest userLoginRequest) {
        return userService.login(userLoginRequest);
    }


    @GetMapping("/info")
    @ApiOperation(value = "获取用户信息")
    public Mono<CommonResponse<UserInfoResponse>> info(@RequestParam("token") String token) {
        return userService.info(token);
    }
}
