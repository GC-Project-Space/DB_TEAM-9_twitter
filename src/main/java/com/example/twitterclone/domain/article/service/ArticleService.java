package com.example.twitterclone.domain.article.service;

import com.example.twitterclone.domain.article.converter.ArticleConverter;
import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.article.dto.ArticleRequest;
import com.example.twitterclone.domain.article.repository.ArticleReadRepository;
import com.example.twitterclone.domain.article.repository.ArticleTagWriteRepository;
import com.example.twitterclone.domain.article.repository.ArticleWriteRepository;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for Example
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleReadRepository articleReadRepository;
    private final ArticleWriteRepository articleWriteRepository;

    private final ArticleTagsService articleTagsService;
    private final ArticleImageService articleImageService;

    private final UsersService usersService;


    /**
     * create
     *
     * @param request: ArticleRequest.CreateDto
     * @return Article
     */
    @Transactional
    public Article create(ArticleRequest.CreateDto request) {
        Users writer = usersService.getUsers(request.getNickname());
        Article article = ArticleConverter.toArticle(request.getContent(), writer);

        // ArticleTag에 target User 추가
        articleTagsService.addUserTags(request.getUserTags(), article);

        // ArticleImage 추가
        articleImageService.addImages(request.getImages(), article);

        return articleWriteRepository.save(article);
    }

    /**
     * getAll
     *
     * @return List<Article>
     */
    @Transactional(readOnly = true)
    public List<Article> getAll() {
        return articleReadRepository.findAllByStatusOrderByCreatedAtDesc();
    }

    /**
     * getFollowing
     *
     * @param userId: Long
     * @return List<Article>
     */
    public List<Article> getFollowing(Long userId) {
        return articleReadRepository.findAllFollowingArticleByStatusOrderByCreatedAtDesc(userId);
    }
}
