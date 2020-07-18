package com.lifaxin.blog.service;

import com.lifaxin.blog.domain.request.article.ArticleRequest;
import com.lifaxin.blog.domain.response.common.CommonResponse;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Description 文章管理Service
 * @Author LiFaXin
 * @Date 2020/7/17 17:11
 * @Version
 **/
public interface IArticleService {

    /**
     * 文章保存
     *
     * @param articleRequest
     * @return
     */
    Mono<CommonResponse> save(ArticleRequest articleRequest);

    /**
     * 获取文章列表
     *
     * @param title
     * @param pageNum
     * @param pageSize
     * @return
     */
    Mono<CommonResponse> list(String title, Integer pageNum, Integer pageSize);
}
