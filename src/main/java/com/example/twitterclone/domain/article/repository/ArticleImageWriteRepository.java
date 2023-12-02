package com.example.twitterclone.domain.article.repository;

import com.example.twitterclone.domain.article.domain.ArticleImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleImageWriteRepository extends JpaRepository<ArticleImage, Long> {

}
