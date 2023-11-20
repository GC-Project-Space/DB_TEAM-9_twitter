package com.example.twitterclone.domain.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Example", description = "예시 API")
@RestController
@RequestMapping("/example")
public class ExampleController {

    @Operation(summary = "Link Test API", description = "서버 연결 테스트용 API")
    @GetMapping("/test")
    public String test() {
        return "Server is running";
    }
}
