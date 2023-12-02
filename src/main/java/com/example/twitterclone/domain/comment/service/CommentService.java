package com.example.twitterclone.domain.comment.service;

import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.article.service.ArticleService;
import com.example.twitterclone.domain.comment.converter.CommentConverter;
import com.example.twitterclone.domain.comment.domain.Comment;
import com.example.twitterclone.domain.comment.dto.CommentRequest;
import com.example.twitterclone.domain.comment.repository.CommentReadRepository;
import com.example.twitterclone.domain.comment.repository.CommentWriteRepository;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.domain.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentReadRepository commentReadRepository;
    private final CommentWriteRepository commentWriteRepository;

    private final UsersService usersService;
    private final ArticleService articleService;

    public Comment create(CommentRequest.CreateDto createDto) {
        Users user = usersService.getUsersById(createDto.getUser_id());
        Article article = articleService.getArticle(createDto.getArticle_id());
        return CommentConverter.toComment(createDto.getContent(), article, user);
    }

    public List<Comment> getCommentList(Long articleId) {
        return commentReadRepository.findAllByArticleId(articleId);
    }
}