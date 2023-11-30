package com.example.twitterclone.domain.article.controller;

import com.example.twitterclone.domain.article.service.ArticleService;
import com.example.twitterclone.domain.users.converter.UsersResponseConverter;
import com.example.twitterclone.domain.users.dto.UsersRequest;
import com.example.twitterclone.domain.users.dto.UsersResponse;
import com.example.twitterclone.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Article", description = "Article API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;


    /**
     * create
     *
     * @method POST
     * @url /articles/create
     * @param request: UsersRequest.SignUpUserDto
     * @return ApiResponse<UsersResponse.SignUpUserDto>
     */
    @PostMapping
    public ApiResponse<ArticleResponse.createDto> create(
            @RequestBody @Valid ArticleRequest.createDto request
    ) {
        Article article = articleService.create(request);
        return ApiResponse.onSuccess(ArticleResponseConverter.tocreateDto(article));
    }

    /**
     * create
     *
     * @method POST
     * @url /articles/create
     * @param request: UsersRequest.SignUpUserDto
     * @return ApiResponse<UsersResponse.SignUpUserDto>
     */
    @GetMapping("/{id}")
    public ApiResponse<ArticleResponse.getarticlebyidDto> getarticlebyid(
            @RequestBody @Valid ArticleRequest.getarticlebyidDto request
    ) {
        Article article = articleService.getarticlebyid(request);
        return ApiResponse.onSuccess(ArticleResponseConverter.getarticlebyidDto(article));
    }
    /**
     * create
     *
     * @method POST
     * @url /articles/create
     * @param request: UsersRequest.SignUpUserDto
     * @return ApiResponse<UsersResponse.SignUpUserDto>
     */
    @PutMapping("/{id}")
    public ApiResponse<ArticleResponse.updatearticlebyidDto> updatearticlebyid(
            @RequestBody @Valid ArticleRequest.updatearticlebyidDto request
    ) {
        Article article = articleService.updatearticlebyid(request);
        return ApiResponse.onSuccess(ArticleResponseConverter.updatearticlebyidDto(article));
    }
    /**
     * create
     *
     * @method POST
     * @url /articles/create
     * @param request: UsersRequest.SignUpUserDto
     * @return ApiResponse<UsersResponse.SignUpUserDto>
     */
    @DeleteMapping("/{id}")
    public ApiResponse<ArticleResponse.deletearticlebyidDto> deletearticlebyid(
            @RequestBody @Valid ArticleRequest.deletearticlebyidDto request
    ) {
        Article article = articleService.deletearticlebyid(request);
        return ApiResponse.onSuccess(ArticleResponseConverter.deletearticlebyidDto(article));
    }

}
