package com.lifaxin.blog.domain.entity;

import com.lifaxin.blog.constaints.ArticleStatusEnum;
import com.lifaxin.blog.utils.DateTimeUtil;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @Description 文章实体类
 * @Author LiFaXin
 * @Date 2020/7/17 15:57
 * @Version
 **/
@Data
@Document("fx-article")
public class ArticleEntity {

    @Id
    private String id;

    @Field("article_title")
    private String articleTitle;

    @Field("article_time")
    private String articleTime = DateTimeUtil.getCurrentDateTimeStr();

    @Field("article_author")
    private List<String> articleAuthor;

    @Field("article_content")
    private String articleContent;

    @Field("article_status")
    private ArticleStatusEnum status;

}
