package com.example.twitterclone.domain.comment.repository;

import com.example.twitterclone.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentWriteRepository extends JpaRepository<Comment, Long> {


}
