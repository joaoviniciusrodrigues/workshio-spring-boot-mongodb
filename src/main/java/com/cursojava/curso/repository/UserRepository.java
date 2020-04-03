package com.cursojava.curso.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cursojava.curso.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
