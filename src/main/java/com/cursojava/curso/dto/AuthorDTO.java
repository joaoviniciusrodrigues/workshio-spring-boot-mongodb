package com.cursojava.curso.dto;

import java.io.Serializable;

import com.cursojava.curso.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	
	public AuthorDTO(User user) {
		this.setId(user.getId());
		this.setName(user.getName());
	}

}
