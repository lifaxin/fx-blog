package com.lifaxin.blog.controller;

import com.lifaxin.blog.domain.request.article.ArticleRequest;
import com.lifaxin.blog.domain.response.article.ArticleResponse;
import com.lifaxin.blog.domain.response.common.CommonResponse;
import com.lifaxin.blog.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Description 文章相关管理
 * @Author LiFaXin
 * @Date 2020/7/17 17:09
 * @Version
 **/
@Api("文章相关管理")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @PostMapping("/save")
    @ApiOperation(value = "保存文章信息")
    public Mono<CommonResponse> save(@RequestBody ArticleRequest articleRequest) {
        return articleService.save(articleRequest);
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取文章列表")
    public Mono<CommonResponse> list(@ApiParam(value = "文章标题", name = "title") @RequestParam(value = "title", required = false) String title,
                                     @ApiParam(value = "当前页数", name = "pageNum") @RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                                     @ApiParam(value = "总页数", name = "pageSize")  @RequestParam(value = "limit", defaultValue = "10") Integer pageSize) {
        return articleService.list(title, --pageNum, pageSize);
    }

}
