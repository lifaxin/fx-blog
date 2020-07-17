package com.lifaxin.blog.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description 文章实体类
 * @Author LiFaXin
 * @Date 2020/7/17 15:57
 * @Version
 **/
@Document("fx-article")
public class ArticleEntity {

    @Id
    private String id;

    private String article_title;



}
