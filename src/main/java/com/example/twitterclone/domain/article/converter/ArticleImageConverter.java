package com.example.twitterclone.domain.article.converter;

import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.article.domain.ArticleImage;

public class ArticleImageConverter {

    public static ArticleImage toArticleImage(Article article, String imageUrl, Integer order) {
        return ArticleImage.builder()
                .article(article)
                .imageUrl(imageUrl)
                .order(order)
                .build();
    }
}
