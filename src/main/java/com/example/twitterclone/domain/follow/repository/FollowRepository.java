package com.example.twitterclone.domain.follow.repository;

import com.example.twitterclone.domain.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {

}
