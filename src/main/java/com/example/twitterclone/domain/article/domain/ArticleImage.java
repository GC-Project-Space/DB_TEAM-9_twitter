
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
@Entity(name = "ARTICLE_IMAGE")
public class ArticleImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "article_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "order_num", nullable = false)
    private Integer order;

}
