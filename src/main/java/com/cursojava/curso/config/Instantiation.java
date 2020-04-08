package com.cursojava.curso.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursojava.curso.domain.Post;
import com.cursojava.curso.domain.User;
import com.cursojava.curso.dto.AuthorDTO;
import com.cursojava.curso.dto.ComentarioDTO;
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

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(maria));

		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(maria));
		
		ComentarioDTO c1 = new ComentarioDTO("Boa viagem!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		ComentarioDTO c2 = new ComentarioDTO("Boa viagem1!", sdf.parse("21/03/2018"), new AuthorDTO(joao));
		ComentarioDTO c3 = new ComentarioDTO("Boa viagem2!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		
		post1.getComments().add(c1);
		post2.getComments().add(c2);
		post1.getComments().add(c3);

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);

	}

}
