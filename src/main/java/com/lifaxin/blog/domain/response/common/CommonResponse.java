package com.lifaxin.blog.domain.response.common;

import lombok.Builder;
import lombok.Data;
import reactor.core.publisher.Mono;

/**
 * @Description 统一返回值
 * @Author LiFaXin
 * @Date 2020/7/17 17:15
 * @Version
 **/
@Data
@Builder
public class CommonResponse<T> {

    private int code;

    private String message;

    private long count;

    private T data;
}
