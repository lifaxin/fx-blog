package com.lifaxin.blog.repository;

import com.lifaxin.blog.domain.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户相关服务
 *
 * @author LiFaXin
 * @date 2020/9/18 20:22
 **/
@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, String> {

    UserEntity findByUserName(String userName);



}
