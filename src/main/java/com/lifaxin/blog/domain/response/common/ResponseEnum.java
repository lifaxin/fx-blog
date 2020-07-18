package com.lifaxin.blog.domain.response.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description
 * @Author LiFaXin
 * @Date 2020/7/17 17:17
 * @Version
 **/
@Getter
@AllArgsConstructor
public enum ResponseEnum {

    FAIL(0, "操作失败！"),
    SUCCESS(20000, "操作成功！");

    private int code;

    private String message;
}
