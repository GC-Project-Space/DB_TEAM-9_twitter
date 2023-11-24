package com.example.twitterclone.domain.users.repository;

import com.example.twitterclone.domain.users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersWriteRepository extends JpaRepository<Users, Long> {

}
