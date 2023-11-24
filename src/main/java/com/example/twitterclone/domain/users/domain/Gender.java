package com.example.twitterclone.domain.users.domain;

import java.util.stream.Stream;

public enum Gender {
    MALE,
    FEAMLE,
    SECRET;

    public static Gender fromString(String gender) {
        return Stream.of(values())
                .filter(Gender -> Gender.name().equals(gender))
                .findFirst()
                .orElse(Gender.SECRET);
    }
}
