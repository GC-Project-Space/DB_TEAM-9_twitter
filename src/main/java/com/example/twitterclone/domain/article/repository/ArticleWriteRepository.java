package com.example.twitterclone.domain.article.repository;

import com.example.twitterclone.domain.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleWriteRepository extends JpaRepository<Article, Long> {

}
