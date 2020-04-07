package com.cursojava.curso.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cursojava.curso.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
