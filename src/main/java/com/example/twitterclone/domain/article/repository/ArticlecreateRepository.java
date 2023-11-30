package com.example.twitterclone.domain.article.repository;

import com.example.twitterclone.domain.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlecreateRepository extends JpaRepository<Article, Long> {

}
