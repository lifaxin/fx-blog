package com.lifaxin.blog.domain.response.article;

import com.lifaxin.blog.constaints.ArticleStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @Description 文章响应结果
 * @Author LiFaXin
 * @Date 2020/7/17 20:49
 * @Version
 **/
@Data
public class ArticleResponse {

    @ApiModelProperty("文章ID")
    private String id;

    @ApiModelProperty("文章内容")
    private String articleTitle;

    @ApiModelProperty("发布时间")
    private String articleTime;

    @ApiModelProperty("文章作者")
    private String articleAuthor;

    @ApiModelProperty("文章内容")
    private String articleContent;

    @ApiModelProperty("文章状态")
    private ArticleStatusEnum status;
}
