package com.example.twitterclone.domain.article.repository;

import com.example.twitterclone.domain.article.domain.ArticleImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleImageReadRepository extends JpaRepository<ArticleImage, Long> {

}
