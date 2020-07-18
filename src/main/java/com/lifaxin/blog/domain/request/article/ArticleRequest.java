package com.lifaxin.blog.domain.request.article;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @Description 文章创建
 * @Author LiFaXin
 * @Date 2020/7/17 17:07
 * @Version
 **/
@Data
public class ArticleRequest {

    @ApiModelProperty(value = "文章标题", required = true)
    private String articleTitle;

    @ApiModelProperty(value = "文章作者", required = true)
    private List<String> articleAuthor;

    @ApiModelProperty(value = "文章内容", required = true)
    private String articleContent;
}
