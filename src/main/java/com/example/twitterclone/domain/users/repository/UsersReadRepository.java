package com.example.twitterclone.domain.users.repository;

import com.example.twitterclone.domain.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersReadRepository extends JpaRepository<Users, Long> {

}
