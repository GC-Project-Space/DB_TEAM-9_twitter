package com.example.twitterclone.domain.users.repository;

import com.example.twitterclone.domain.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersValidRepository extends JpaRepository<Users, Long> {

    boolean existsByNickname(String nickname);

    boolean existsByEmail(String email);
}
