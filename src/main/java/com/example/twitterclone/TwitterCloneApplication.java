package com.example.twitterclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA Auditing 활성화
public class TwitterCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterCloneApplication.class, args);
    }

}
