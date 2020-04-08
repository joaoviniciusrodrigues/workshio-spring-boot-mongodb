package com.cursojava.curso.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cursojava.curso.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{' title': { $regex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String title);

}
