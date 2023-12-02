package com.example.twitterclone.domain.article.service;

import com.example.twitterclone.domain.article.converter.ArticleImageConverter;
import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.article.domain.ArticleImage;
import com.example.twitterclone.domain.article.dto.ArticleRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

/**
 * Service class for Example
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleImageService {

    public void addImages(List<ArticleRequest.ImageDto> images, Article article) {
        Stream.iterate(0, i -> i + 1)
                .limit(images.size())
                .forEach(i -> {
                    ArticleImage articleImage = ArticleImageConverter.toArticleImage(
                            article, images.get(i).getImageUrl(), images.get(i).getOrder()
                    );
                    article.getArticleImages().add(articleImage);
                });
    }

}
