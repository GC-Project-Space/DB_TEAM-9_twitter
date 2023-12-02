package com.example.twitterclone.domain.article.repository;

import com.example.twitterclone.domain.article.domain.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTagWriteRepository extends JpaRepository<ArticleTag, Long> {

}
