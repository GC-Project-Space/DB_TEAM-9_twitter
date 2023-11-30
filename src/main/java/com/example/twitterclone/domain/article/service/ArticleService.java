package com.example.twitterclone.domain.article.service;

import com.example.twitterclone.domain.article.controller.ArticleController;
import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.article.dto.ArticleRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for Example
 */
@Slf4j
@RequiredArgsConstructor
@Service

public class ArticleService {
    private final ArticleRepository articlecreateRepository;
    private final ArticleRepository getarticleidRepository;
    private final ArticleRepository updatearticleidRepository;
    private final ArticleRepository deletearticleidRepository;

    @Transactional
    public Article create(ArticleRequest.createDto request) {
        Article article = ArticleController.tocreate(request);
        return articlecreateRepository.save(article);
    }

    @Transactional
    public Article getarticlebyid(ArticleRequest.getarticlebyidDto request) {
        Article article = ArticleController.getarticlebyid(request);
        return getarticleidRepository.save(article);
    }

    @Transactional
    public Article updatearticlebyid(ArticleRequest.updatearticlebyidDto request) {
        Article article = ArticleController.updatearticlebyid(request);
        return updatearticleidRepository.save(article);
    }

    @Transactional
    public Article deletearticlebyid(ArticleRequest.deletearticlebyidDto request) {
        Article article = ArticleController.deletearticlebyid(request);
        return deletearticleidRepository.save(article);
    }
}
