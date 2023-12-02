package com.example.twitterclone.domain.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class ArticleResponse {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateDto {
        private String message;
        private Long article_id;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetArticleDto {
        private Long article_id;
        private String content;
        private UserDto writer;
        private LocalDateTime createdAt;

        private Integer likeCount;
        private Integer commentCount;
        private List<ImageDto> images;
        private List<UserDto> userTags;
    }

    @Getter
    @Builder
    public static class ImageDto {
        private String imageUrl;
        private Integer order;
    }

    @Getter
    @Builder
    public static class UserDto {
        private Long user_id;
        private String nickname;
        private String profileImageUrl;
    }
}
