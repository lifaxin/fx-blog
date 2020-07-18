package com.lifaxin.blog.repository;

import com.lifaxin.blog.domain.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.CountQuery;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 文章保存Repository
 *
 * @Author LiFaXin
 * @Date 2020/7/17 17:29
 * @Version
 **/
@Repository
public interface ArticleRepository extends ReactiveCrudRepository<ArticleEntity, String> {

    @Query(value="{article_title:?#{([0] == null) ? {$exists:true} : [0]}}")
    Flux<ArticleEntity> findByPage(String title, Pageable pageable);

    @CountQuery(value="{article_title:?#{([0] == null) ? {$exists:true} : [0]}}")
    Mono<Long> countForPage(String title);
}
