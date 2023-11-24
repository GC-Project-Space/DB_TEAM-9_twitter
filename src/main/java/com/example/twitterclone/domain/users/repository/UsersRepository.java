package com.example.twitterclone.domain.users.repository;

import com.example.twitterclone.domain.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
