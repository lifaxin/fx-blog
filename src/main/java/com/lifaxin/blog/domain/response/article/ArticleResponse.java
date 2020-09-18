package com.lifaxin.blog.domain.response.article;

import com.lifaxin.blog.constaints.ArticleStatusEnum;
import lombok.Data;

/**
 * @Description 文章响应结果
 * @Author LiFaXin
 * @Date 2020/7/17 20:49
 * @Version
 **/
@Data
public class ArticleResponse {

    /**
     * 文章ID
     */
    private String id;

    /**
     * 文章内容
     */
    private String articleTitle;

    /**
     * 发布时间
     */
    private String articleTime;

    /**
     * 文章作者
     */
    private String articleAuthor;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章状态
     */
    private ArticleStatusEnum status;
}
