package com.lifaxin.blog.controller;

import com.lifaxin.blog.domain.request.user.UserLoginRequest;
import com.lifaxin.blog.domain.response.common.CommonResponse;
import com.lifaxin.blog.domain.response.user.UserInfoResponse;
import com.lifaxin.blog.domain.response.user.UserLoginResponse;
import com.lifaxin.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @Description 用户相关信息
 * @Author LiFaXin
 * @Date 2020/7/18 18:38
 * @Version
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 用户登录
     *
     * @param userLoginRequest
     * @return reactor.core.publisher.Mono<com.lifaxin.blog.domain.response.common.CommonResponse < com.lifaxin.blog.domain.response.user.UserLoginResponse>>
     * @author LiFaXin
     * @date 2020/9/18 20:02
     */
    @PostMapping("/login")
    public Mono<CommonResponse<UserLoginResponse>> login(@RequestBody UserLoginRequest userLoginRequest) {
        return userService.login(userLoginRequest);
    }


    /**
     * 获取用户信息
     *
     * @param token
     * @return reactor.core.publisher.Mono<com.lifaxin.blog.domain.response.common.CommonResponse < com.lifaxin.blog.domain.response.user.UserInfoResponse>>
     * @author LiFaXin
     * @date 2020/9/18 20:09
     */
    @GetMapping("/info")
    public Mono<CommonResponse<UserInfoResponse>> info(@RequestParam("token") String token) {
        return userService.info(token);
    }
}
