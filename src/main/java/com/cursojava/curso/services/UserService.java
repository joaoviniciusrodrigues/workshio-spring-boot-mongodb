package com.cursojava.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.curso.domain.User;
import com.cursojava.curso.dto.UserDTO;
import com.cursojava.curso.repository.UserRepository;
import com.cursojava.curso.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		if (user.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontradoro");
		}

		return user.get();
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

	public void delete(String id) {
		this.findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = repo.findById(obj.getId()).get();
		udateDate(newObj, obj);
		return repo.save(newObj);
	}

	private void udateDate(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());		
	}

}
