package com.javaee.restswagger.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

	private Long id;
	
	private String name;
	
	private String password;
	
	private Boolean active;

	private String role;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
}
