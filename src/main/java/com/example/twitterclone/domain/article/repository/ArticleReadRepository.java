package com.example.twitterclone.domain.article.repository;

import com.example.twitterclone.domain.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleReadRepository extends JpaRepository<Article, Long> {

    @Query("select a " +
            "from ARTICLE a " +
            "where a.status = 'ACTIVE' " +
            "order by a.createdAt desc")
    List<Article> findAllByStatusOrderByCreatedAtDesc();

    @Query(value = "select a " +
            "from ARTICLE a " +
            "where a.status = 'ACTIVE' and " +
            "      a.writer = exists (" +
            "       select f.to_user " +
            "       from FOLLOW f " +
            "       where f.from_user = :userId)" +
            "order by a.createdAt desc",
            nativeQuery = true)
    List<Article> getFollowUsersArticleList(Long userId);
}
