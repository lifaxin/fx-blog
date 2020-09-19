package com.lifaxin.blog.controller;

import com.lifaxin.blog.domain.request.article.ArticleRequest;
import com.lifaxin.blog.domain.response.common.CommonResponse;
import com.lifaxin.blog.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @Description 文章相关管理
 * @Author LiFaXin
 * @Date 2020/7/17 17:09
 * @Version
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    /**
     * 保存文章
     *
     * @param articleRequest
     * @return reactor.core.publisher.Mono<com.lifaxin.blog.domain.response.common.CommonResponse>
     * @author LiFaXin
     * @date 2020/9/18 20:12
     */
    @PostMapping("/draft")
    public Mono<CommonResponse> draft(@RequestBody ArticleRequest articleRequest) {
        return articleService.save(articleRequest);
    }

    /**
     *
     *
     * @param title     文章标题
     * @param pageNum   当前页数
     * @param pageSize  总页数
     * @return reactor.core.publisher.Mono<com.lifaxin.blog.domain.response.common.CommonResponse>
     * @author LiFaXin
     * @date 2020/9/18 20:10
     */
    @GetMapping("/list")
    public Mono<CommonResponse> list(@RequestParam(value = "title", required = false) String title,
                                     @RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "limit", defaultValue = "10") Integer pageSize) {
        return articleService.list(title, --pageNum, pageSize);
    }

}
