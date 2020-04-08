package com.cursojava.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.curso.domain.Post;
import com.cursojava.curso.repository.PostRepository;
import com.cursojava.curso.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findAll() {
		return repo.findAll();
	}

	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		if (post.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontradoro");
		}

		return post.get();
	}
	
	public Post findByTitle(String text) {
		Post post = repo.searchTitle(text).get(0);
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontradoro");
		}

		return post;
	}

	public Post insert(Post obj) {
		return repo.insert(obj);
	}


	public void delete(String id) {
		this.findById(id);
		repo.deleteById(id);
	}
	


	

}

