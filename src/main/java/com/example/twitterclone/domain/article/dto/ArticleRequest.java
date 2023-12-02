package com.example.twitterclone.domain.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ArticleRequest {

    @Getter
    @Builder
    public static class CreateDto {
        @NotNull(message = "내용을 입력해주세요.")
        private String content;

        @NotNull(message = "작성자를 입력해주세요.")
        private String nickname;

        private List<ImageDto> images;
        private List<String> userTags;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImageDto {
        private String imageUrl;
        private Integer order;
    }

}