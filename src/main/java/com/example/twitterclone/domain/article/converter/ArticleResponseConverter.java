package com.example.twitterclone.domain.article.converter;

import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.article.domain.ArticleImage;
import com.example.twitterclone.domain.article.domain.ArticleTag;
import com.example.twitterclone.domain.article.dto.ArticleResponse;
import com.example.twitterclone.domain.users.domain.Users;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleResponseConverter {

    public static ArticleResponse.CreateDto toCreateDto(Article article) {
        return ArticleResponse.CreateDto.builder()
                .message("게시글이 등록되었습니다.")
                .article_id(article.getId())
                .build();
    }

    public static List<ArticleResponse.GetArticleDto> toGetArticleDto(List<Article> articles) {
        return articles.stream()
                .map(article -> ArticleResponse.GetArticleDto.builder()
                        .article_id(article.getId())
                        .content(article.getContent())
                        .writer(toWriterDto(article.getWriter()))
                        .likeCount(article.getArticleLikes().size())
                        .commentCount(article.getComments().size())
                        .images(toImageDto(article.getArticleImages()))
                        .userTags(toUserDto(article.getArticleTags()))
                        .build())
                .collect(Collectors.toList());
    }

    private static List<ArticleResponse.UserDto> toUserDto(List<ArticleTag> articleTags) {
        return articleTags.stream()
                .map(articleTag -> ArticleResponse.UserDto.builder()
                        .user_id(articleTag.getTarget().getId())
                        .nickname(articleTag.getTarget().getNickname())
                        .profileImageUrl(articleTag.getTarget().getProfileImage())
                        .build())
                .collect(Collectors.toList());
    }

    private static List<ArticleResponse.ImageDto> toImageDto(List<ArticleImage> articleImages) {
        return articleImages.stream()
                .map(articleImage -> ArticleResponse.ImageDto.builder()
                        .imageUrl(articleImage.getImageUrl())
                        .order(articleImage.getOrder())
                        .build())
                .collect(Collectors.toList());
    }

    private static ArticleResponse.UserDto toWriterDto(Users writer) {
        return ArticleResponse.UserDto.builder()
                .user_id(writer.getId())
                .nickname(writer.getNickname())
                .profileImageUrl(writer.getProfileImage())
                .build();
    }
}
