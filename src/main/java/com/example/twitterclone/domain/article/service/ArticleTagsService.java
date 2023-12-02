package com.example.twitterclone.domain.article.service;

import com.example.twitterclone.domain.article.converter.ArticleTagConverter;
import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.article.domain.ArticleTag;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.service.UsersService;
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
public class ArticleTagsService {

    private final UsersService usersService;

    public void addUserTags(List<String> userTags, Article article) {
        Stream.iterate(0, i -> i + 1)
                .limit(userTags.size())
                .forEach(i -> {
                    Users target = usersService.getUsers(userTags.get(i));
                    ArticleTag articleTag = ArticleTagConverter.toArticleTag(article, target);
                    article.getArticleTags().add(articleTag);
                });
    }
}
