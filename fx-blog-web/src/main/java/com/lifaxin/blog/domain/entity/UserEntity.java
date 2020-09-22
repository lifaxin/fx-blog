package com.lifaxin.blog.domain.entity;

import com.lifaxin.blog.constaints.UserStatusEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * 用户相关数据库实体
 *
 * @author LiFaXin
 * @date 2020/9/18 20:23
 **/
@Data
@Document("fx_sys_user")
public class UserEntity {

    @Id
    private String id;

    /**
     * 用户名
     */
    @Field
    private String userName;

    /**
     * 昵称
     */
    @Field
    private String nickName;

    /**
     * 密文
     */
    @Field
    private String passWord;

    /**
     * 密码设置时间
     */
    @Field
    private LocalDateTime passWordSetTime;

    /**
     * 加密方式 salt:sha次数
     */
    @Field
    private String encryptMethod;

    /**
     * 签名
     */
    @Field
    private String signature;

    /**
     * 创建时间
     */
    @Field
    private UserStatusEnum userStatus;

    /**
     * 创建时间
     */
    @Field
    private LocalDateTime createTime;


    /**
     * 最后登录时间
     */
    @Field
    private LocalDateTime lastLoginTime;
}
