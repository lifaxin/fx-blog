package com.lifaxin.blog.service;

import com.lifaxin.blog.domain.request.user.UserLoginRequest;
import com.lifaxin.blog.domain.response.common.CommonResponse;
import com.lifaxin.blog.domain.response.user.UserInfoResponse;
import com.lifaxin.blog.domain.response.user.UserLoginResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import reactor.core.publisher.Mono;

/**
 * @Description 用户相关接口
 * @Author LiFaXin
 * @Date 2020/7/18 18:41
 * @Version
 **/
public interface UserService extends UserDetailsService {

    /**
     * 用户登录接口
     *
     * @param userLoginRequest
     * @return
     */
    Mono<CommonResponse<UserLoginResponse>> login(UserLoginRequest userLoginRequest);

    /**
     * 获取用户信息
     *
     * @param token
     * @return
     */
    Mono<CommonResponse<UserInfoResponse>> info(String token);
}
