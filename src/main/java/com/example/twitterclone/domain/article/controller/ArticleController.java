package com.example.twitterclone.domain.article.controller;

import com.example.twitterclone.domain.article.converter.ArticleResponseConverter;
import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.article.dto.ArticleRequest;
import com.example.twitterclone.domain.article.dto.ArticleResponse;
import com.example.twitterclone.domain.article.service.ArticleService;
import com.example.twitterclone.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/create")
    public ApiResponse<ArticleResponse.CreateDto> create(
            @RequestBody @Valid ArticleRequest.CreateDto request
    ) {
        Article article = articleService.create(request);
        return ApiResponse.onSuccess(ArticleResponseConverter.toCreateDto(article));
    }

    /**
     * getAll
     *
     * @method GET
     * @url /articles/get-all
     * @return ApiResponse<List<ArticleResponse.GetArticleDto>>
     */
    @GetMapping("/get-all")
    public ApiResponse<List<ArticleResponse.GetArticleDto>> getAll() {
        List<Article> articles = articleService.getAll();
        return ApiResponse.onSuccess(ArticleResponseConverter.toGetArticleDto(articles));
    }

    /**
     * getFollowing
     *
     * @method GET
     * @url /articles/get-following/{userId}
     * @param userId: Long
     * @return ApiResponse<List<ArticleResponse.GetArticleDto>>
     */
    @GetMapping("/get-following/{userId}")
    public ApiResponse<List<ArticleResponse.GetArticleDto>> getFollowing(
            @PathVariable("userId") Long userId
    ) {
        List<Article> articles = articleService.getFollowing(userId);
        return ApiResponse.onSuccess(ArticleResponseConverter.toGetArticleDto(articles));
    }

    /**
     * getUserArticles
     *
     * @method GET
     * @url /articles/get-article/{userId}
     * @param userId: Long
     * @return ApiResponse<List<ArticleResponse.GetArticleDto>>
     */
    @GetMapping("/get-article/{userId}")
    public ApiResponse<List<ArticleResponse.GetArticleDto>> getUserArticles(
            @PathVariable("userId") Long userId
    ) {
        List<Article> articles = articleService.getUserArticles(userId);
        return ApiResponse.onSuccess(ArticleResponseConverter.toGetArticleDto(articles));
    }

}
