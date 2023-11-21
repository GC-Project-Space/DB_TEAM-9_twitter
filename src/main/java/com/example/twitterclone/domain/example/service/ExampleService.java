package com.example.twitterclone.domain.example.service;

import com.example.twitterclone.domain.example.converter.ExampleConverter;
import com.example.twitterclone.domain.example.domain.Example;
import com.example.twitterclone.domain.example.dto.ExampleRequest;
import com.example.twitterclone.domain.example.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service class for Example
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ExampleService {
    private final ExampleRepository exampleRepository;

    public Example exampleCreate(ExampleRequest.ExampleCreateDto exampleCreateDto) {
        Example example = ExampleConverter.toExample(exampleCreateDto);
        return exampleRepository.save(example);
    }
}
