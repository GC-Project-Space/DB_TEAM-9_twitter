package com.example.twitterclone.domain.follow.repository;

import com.example.twitterclone.domain.follow.domain.Follow;
import com.example.twitterclone.domain.follow.dto.FollowResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Query("select count(f) from FOLLOW f where f.to_user.email = :email")
    int followingCountByEmail(String email);

    @Query("select count(f) from FOLLOW f where f.from_user.email = :email")
    int followerCountByEmail(String email);
}
