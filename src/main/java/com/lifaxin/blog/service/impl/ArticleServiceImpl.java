package com.lifaxin.blog.service.impl;

import com.lifaxin.blog.constaints.ArticleStatusEnum;
import com.lifaxin.blog.domain.entity.ArticleEntity;
import com.lifaxin.blog.domain.request.article.ArticleRequest;
import com.lifaxin.blog.domain.response.article.ArticleResponse;
import com.lifaxin.blog.domain.response.common.CommonResponse;
import com.lifaxin.blog.domain.response.common.R;
import com.lifaxin.blog.repository.ArticleRepository;
import com.lifaxin.blog.service.IArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 文章管理实现类
 * @Author LiFaXin
 * @Date 2020/7/17 17:12
 * @Version
 **/
@Service
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleRepository articleRepository;

    @Override
    public Mono<CommonResponse> save(ArticleRequest articleRequest) {
        ArticleEntity articleEntity = new ArticleEntity();
        BeanUtils.copyProperties(articleRequest, articleEntity);
        // 设置默认状态
        articleEntity.setStatus(ArticleStatusEnum.EDIT);
        return articleRepository.save(articleEntity).map(item -> {
            if (StringUtils.isNotBlank(item.getId())){
                return R.OK();
            } else {
                return R.FAIL();
            }
        });
    }

    @Override
    public Mono<CommonResponse> list(String title, Integer pageNum, Integer pageSize) {
        // 获取总条数
        Mono<Long> countMono = articleRepository.countForPage(title);
        // 分页条件查询
        Sort sort = Sort.by(Sort.Direction.DESC, "articleTime");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Mono<List<ArticleResponse>> articleListMono  = articleRepository.findByPage(title, pageable).map(item -> {
            ArticleResponse articleResponse = new ArticleResponse();
            BeanUtils.copyProperties(item, articleResponse);
            return articleResponse;
        }).collectList();
        // 数据合并返回
        return countMono.flatMap(_count -> articleListMono.map(_data -> R.PAGE(_count, _data)));
    }
}
