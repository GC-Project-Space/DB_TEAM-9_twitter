package com.example.twitterclone.domain.article.domain;

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
@Entity(name = "ARTICLE")
public class Article extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @JoinColumn(name = "writer_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Users writer;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}