package com.example.twitterclone.domain.example.repository;

import com.example.twitterclone.domain.example.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example, Long> {

}
