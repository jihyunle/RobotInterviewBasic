package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface JobRepository extends CrudRepository<Job, Long> {
    Job findByKeyword(String keyword);
    Job findByKeywords(ArrayList<String> keywords);
}
