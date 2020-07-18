package com.lifaxin.blog.service.impl;

import com.lifaxin.blog.domain.request.user.UserLoginRequest;
import com.lifaxin.blog.domain.response.common.CommonResponse;
import com.lifaxin.blog.domain.response.common.R;
import com.lifaxin.blog.domain.response.user.UserInfoResponse;
import com.lifaxin.blog.domain.response.user.UserLoginResponse;
import com.lifaxin.blog.service.IUserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * @Description 用户相关管理实现
 * @Author LiFaXin
 * @Date 2020/7/18 18:42
 * @Version
 **/
@Service
public class UserServiceImpl implements IUserService {


    @Override
    public Mono<CommonResponse<UserLoginResponse>> login(UserLoginRequest userLoginRequest) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setToken("12345");
        return Mono.just(R.OK(userLoginResponse));
    }

    @Override
    public Mono<CommonResponse<UserInfoResponse>> info(String token) {
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfoResponse.setName("李法新");
        userInfoResponse.setIntroduction("这是一个FX博客系统");
        userInfoResponse.setRoles(Arrays.asList("admin"));
        return Mono.just(R.OK(userInfoResponse));
    }
}
