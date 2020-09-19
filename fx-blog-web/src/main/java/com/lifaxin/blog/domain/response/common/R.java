package com.lifaxin.blog.domain.response.common;

import reactor.core.publisher.Mono;

/**
 * @Description 返回值
 * @Author LiFaXin
 * @Date 2020/7/17 17:16
 * @Version
 **/
public class R {

    public static <T> CommonResponse OK(){
        CommonResponse commonResponse = CommonResponse.builder()
                .code(ResponseEnum.SUCCESS.getCode())
                .message(ResponseEnum.SUCCESS.getMessage())
                .build();
        return commonResponse;
    }

    /**
     * 返回成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResponse OK(T data){
        CommonResponse commonResponse = CommonResponse.builder()
                .code(ResponseEnum.SUCCESS.getCode())
                .message(ResponseEnum.SUCCESS.getMessage())
                .data(data)
                .build();
        return commonResponse;
    }

    /**
     * 操作失败
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResponse FAIL(){
        CommonResponse commonResponse = CommonResponse.builder()
                .code(ResponseEnum.FAIL.getCode())
                .message(ResponseEnum.FAIL.getMessage())
                .build();
        return commonResponse;
    }

    /**
     * 已知原因返回
     *
     * @param responseEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResponse OK(ResponseEnum responseEnum, T data){
        CommonResponse commonResponse = CommonResponse.builder()
                .code(responseEnum.getCode())
                .message(responseEnum.getMessage())
                .data(data)
                .build();
        return commonResponse;
    }

    /**
     * 已知原因失败
     *
     * @param responseEnum
     * @param <T>
     * @return
     */
    public static <T> CommonResponse FAIL(ResponseEnum responseEnum){
        CommonResponse commonResponse = CommonResponse.builder()
                .code(responseEnum.getCode())
                .message(responseEnum.getMessage())
                .build();
        return commonResponse;
    }


    public static <T> CommonResponse PAGE(long count, T data){
        CommonResponse commonResponse = CommonResponse.builder()
                .code(ResponseEnum.SUCCESS.getCode())
                .message(ResponseEnum.SUCCESS.getMessage())
                .count(count)
                .data(data)
                .build();
        return commonResponse;
    }
}
