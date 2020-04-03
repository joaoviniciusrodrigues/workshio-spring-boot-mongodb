package com.cursojava.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursojava.curso.domain.User;
import com.cursojava.curso.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null,"Maria Brown","maria@gmail.com");
		User alex = new User(null,"Alex Brown","alex@gmail.com");
		User joao = new User(null,"Joao","joao@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,joao));
		
	}

}
