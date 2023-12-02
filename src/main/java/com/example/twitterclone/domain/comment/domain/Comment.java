package com.example.twitterclone.domain.comment.domain;

import com.example.twitterclone.domain.article.domain.Article;
import com.example.twitterclone.domain.users.domain.Users;
import com.example.twitterclone.global.common.entity.BaseEntity;
import com.example.twitterclone.global.constant.Status;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "COMMENT")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment", nullable = false)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @Column(name = "status", nullable = false,
            columnDefinition = "enum ('ACTIVE', 'INACTIVE', 'DELETED') default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private Status status;
}
