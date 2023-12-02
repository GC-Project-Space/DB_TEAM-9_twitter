package com.example.twitterclone.domain.comment.converter;

import com.example.twitterclone.domain.comment.domain.Comment;
import com.example.twitterclone.domain.comment.dto.CommentResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CommentResponseConverter {

    public static CommentResponse.CreateDto toCreateDto(Comment comment) {
        return CommentResponse.CreateDto.builder()
                .id(comment.getId())
                .build();
    }

    public static List<CommentResponse.CommentDto> toCommentDtoList(List<Comment> comments) {
        return comments.stream()
                .map(comment -> CommentResponse.CommentDto.builder()
                        .id(comment.getId())
                        .content(comment.getComment())
                        .createdDate(comment.getCreatedAt())
                        .user_id(comment.getUser().getId())
                        .user_name(comment.getUser().getName())
                        .user_nickname(comment.getUser().getNickname())
                        .profile_image(comment.getUser().getProfileImage())
                        .build())
                .collect(Collectors.toList());
    }
}

