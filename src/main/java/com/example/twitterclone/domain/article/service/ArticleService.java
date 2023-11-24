package com.example.twitterclone.domain.article.service;

import com.example.twitterclone.domain.article.converter.ArticleConverter;
import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.article.dto.ArticleRequest;
import com.example.twitterclone.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service class for Example
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

}
