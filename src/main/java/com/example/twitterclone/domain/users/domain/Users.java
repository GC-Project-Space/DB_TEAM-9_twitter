package com.example.twitterclone.domain.users.domain;

import com.example.twitterclone.domain.users.util.Gender;
import com.example.twitterclone.global.common.entity.BaseEntity;
import com.example.twitterclone.global.constant.Status;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Slf4j
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "USERS")
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "nickname", nullable = false, length = 100)
    private String nickname;

    @Column(name = "phone", nullable = false, length = 100)
    private String phone;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender; // 성별: MALE, FEMALE, SECRET

    @Column(name = "brith", length = 100)
    private String brith;

    @Column(name = "profile_image", length = 100)
    private String profileImage;

    @Column(name = "status", nullable = false,
            columnDefinition = "enum ('ACTIVE', 'INACTIVE', 'DELETED') default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private Status status;
}
