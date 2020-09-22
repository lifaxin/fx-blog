package com.lifaxin.blog.service.impl;

import com.lifaxin.blog.constaints.UserStatusEnum;
import com.lifaxin.blog.domain.entity.UserEntity;
import com.lifaxin.blog.domain.request.user.UserLoginRequest;
import com.lifaxin.blog.domain.response.common.CommonResponse;
import com.lifaxin.blog.domain.response.common.R;
import com.lifaxin.blog.domain.response.user.UserInfoResponse;
import com.lifaxin.blog.domain.response.user.UserLoginResponse;
import com.lifaxin.blog.repository.UserRepository;
import com.lifaxin.blog.security.JwtUserDetails;
import com.lifaxin.blog.service.UserService;
import com.lifaxin.blog.utils.DateTimeUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 用户相关管理实现
 * @Author LiFaXin
 * @Date 2020/7/18 18:42
 * @Version
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    /**
     * 用户登录
     *
     * @param userLoginRequest
     * @return reactor.core.publisher.Mono<com.lifaxin.blog.domain.response.common.CommonResponse < com.lifaxin.blog.domain.response.user.UserLoginResponse>>
     * @author LiFaXin
     * @date 2020/9/18 20:35
     */
    @Override
    public Mono<CommonResponse<UserLoginResponse>> login(UserLoginRequest userLoginRequest) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        // 根据用户名获取数据库中相同用户名的密文密码进行比对

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

    /**
     * 用户授权
     *
     * @param username
     * @return org.springframework.security.core.userdetails.UserDetails
     * @author LiFaXin
     * @date 2020/9/22 11:55
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据账号获取
        UserEntity userEntity = userRepository.findByUserName(username);
        // 获取账号权限集合
        Set<GrantedAuthority> authorities = new HashSet<>();
        // 获取用户状态
        boolean enabled = UserStatusEnum.AVAILABLE.equals(userEntity.getUserStatus());
        // 密码是否过期
        boolean accountNonExpired = DateTimeUtil.compareDateTime(LocalDateTime.now(), DateTimeUtil.plusDateTime(userEntity.getPassWordSetTime(), 2, ChronoUnit.MONTHS));
        // 账号是否可用
        boolean accountNonLocked = UserStatusEnum.AVAILABLE.equals(userEntity.getUserStatus());
        // 执行授权操作
        return new JwtUserDetails(username, userEntity.getPassWord(), enabled, accountNonExpired, true, accountNonLocked, authorities);
    }
}
