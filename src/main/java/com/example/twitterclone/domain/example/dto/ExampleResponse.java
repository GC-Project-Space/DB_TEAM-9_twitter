package com.example.twitterclone.domain.example.dto;

import lombok.Builder;
import lombok.Getter;

public class ExampleResponse {

    @Getter
    @Builder
    public static class ExampleCreateDto {
        private String massage;
        private String massageInExample;
    }
}
