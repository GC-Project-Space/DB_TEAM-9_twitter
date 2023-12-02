package com.example.twitterclone.domain.article.converter;

import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.article.domain.ArticleTag;
import com.example.twitterclone.domain.users.domain.Users;

public class ArticleTagConverter {


    public static ArticleTag toArticleTag(Article article, Users target) {
        return ArticleTag.builder()
                .article(article)
                .target(target)
                .build();
    }
}
