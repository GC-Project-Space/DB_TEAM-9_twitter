package com.example.twitterclone.domain.article.converter;

import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.global.constant.Status;

public class ArticleConverter {

    public static Article toArticle(String content, Users writer) {
        return Article.builder()
                .content(content)
                .writer(writer)
                .status(Status.ACTIVE)
                .build();
    }
}
