package com.example.twitterclone.domain.example.controller;

import com.example.twitterclone.domain.example.converter.ExampleConverter;
import com.example.twitterclone.domain.example.domain.Example;
import com.example.twitterclone.domain.example.dto.ExampleRequest;
import com.example.twitterclone.domain.example.dto.ExampleResponse;
import com.example.twitterclone.domain.example.service.ExampleService;
import com.example.twitterclone.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Example", description = "예시 API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/example")
public class ExampleController {

    private final ExampleService exampleService;

    @Operation(summary = "Link Test API", description = "서버 연결 테스트용 API")
    @GetMapping("/test")
    public ApiResponse<String> test() {
        return ApiResponse.onSuccess("Server is running");
    }

    @Operation(summary = "Example Create API", description = "예시 생성 API")
    @Parameters({
            @Parameter(name = "massage", description = "예시 메시지", required = true)
    })
    @PostMapping("/create")
    public ApiResponse<ExampleResponse.ExampleCreateDto> create(
            @RequestBody ExampleRequest.ExampleCreateDto exampleCreateDto
    ) {
        Example example = exampleService.exampleCreate(exampleCreateDto);
        return ApiResponse.onSuccess(ExampleConverter.toExampleResponse(example.getMassage()));
    }
}
