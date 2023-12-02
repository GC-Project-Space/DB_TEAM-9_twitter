package com.example.twitterclone.domain.comment.repository;

import com.example.twitterclone.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentReadRepository extends JpaRepository<Comment, Long> {


    List<Comment> findAllByArticleId(Long articleId);
}
