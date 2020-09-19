package com.lifaxin.blog.domain.request.article;

import lombok.Data;

import java.util.List;

/**
 * @Description 文章创建
 * @Author LiFaXin
 * @Date 2020/7/17 17:07
 * @Version
 **/
@Data
public class ArticleRequest {

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章作者
     */
    private List<String> articleAuthor;

    /**
     * 文章内容
     */
    private String articleContent;
}
