package com.example.twitterclone.domain.follow.domain;

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
@Entity(name = "FOLLOW")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "to_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Users to_user; // 팔로우 당하는 사람

    @JoinColumn(name = "from_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Users from_user; // 팔로우 하는 사람
}
