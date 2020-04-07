package com.cursojava.curso.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursojava.curso.domain.Post;
import com.cursojava.curso.domain.User;
import com.cursojava.curso.repository.PostRepository;
import com.cursojava.curso.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Brown", "alex@gmail.com");
		User joao = new User(null, "Joao", "joao@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, joao));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem",
				"Vou viajar para São Paulo. Abraços!", maria);

		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem",
				"Vou viajar para São Paulo. Abraços!", maria);
		
		postRepository.saveAll(Arrays.asList(post1,post2));

	}

}
