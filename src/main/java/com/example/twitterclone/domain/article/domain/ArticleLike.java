package com.example.twitterclone.domain.article.domain;

import com.example.twitterclone.domain.users.domain.Users;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "ARTICLE_TAG")
public class ArticleLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "article_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @JoinColumn(name = "target_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Users target;

}
