package com.example.twitterclone.domain.comment.converter;

import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.comment.domain.Comment;
import com.example.twitterclone.domain.users.domain.Users;

public class CommentConverter {

    public static Comment toComment(String content, Article article, Users user) {
        return Comment.builder()
                .comment(content)
                .article(article)
                .user(user)
                .build();
    }
}

