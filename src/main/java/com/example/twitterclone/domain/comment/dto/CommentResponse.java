package com.example.twitterclone.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class CommentResponse {

    @Getter
    @Builder
    public static class CreateDto {
        private Long id;
    }

    @Getter
    @Builder
    public static class CommentDto {
        private Long id;
        private String content;
        private LocalDateTime createdDate;

        private Long user_id;
        private String user_name;
        private String user_nickname;
        private String profile_image;
    }
}