package com.example.twitterclone.domain.comment.controller;

import com.example.twitterclone.domain.comment.converter.CommentResponseConverter;
import com.example.twitterclone.domain.comment.domain.Comment;
import com.example.twitterclone.domain.comment.dto.CommentRequest;
import com.example.twitterclone.domain.comment.dto.CommentResponse;
import com.example.twitterclone.domain.comment.service.CommentService;
import com.example.twitterclone.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Comments", description = "Comment API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 생성
     *
     * @method POST
     * @url /comment/create
     * @param request: CommentRequest.CreateDto
     * @return ApiResponse<CommentResponse.CreateDto>
     */
    @Operation(summary = "댓글 생성", description = "댓글 생성 API")
    @PostMapping("/create")
    public ApiResponse<CommentResponse.CreateDto> create(
            @RequestBody CommentRequest.CreateDto request
    ) {
        Comment comment = commentService.create(request);
        return ApiResponse.onSuccess(CommentResponseConverter.toCreateDto(comment));
    }

    /**
     * 댓글 리스트
     *
     * @method GET
     * @url /comment/list
     * @param article_id: Long
     * @return ApiResponse<List<CommentResponse.CommentDto>>
     */
    @Operation(summary = "댓글 리스트", description = "댓글 리스트 API")
    @GetMapping("/list")
    public ApiResponse<List<CommentResponse.CommentDto>> list(
            @RequestParam Long article_id
    ) {
        List<Comment> comments = commentService.getCommentList(article_id);
        return ApiResponse.onSuccess(CommentResponseConverter.toCommentDtoList(comments));
    }
}