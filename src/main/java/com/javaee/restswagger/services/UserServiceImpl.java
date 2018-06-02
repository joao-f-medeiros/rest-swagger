package com.javaee.restswagger.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javaee.restswagger.domain.User;
import com.javaee.restswagger.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService{

	private List<User> users = new ArrayList<>();
	private Long actualId = 0L;

	@Override
	public User getById(Long id) {
		return this.users
                .stream().filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public List<User> getAllUsers() {
        return this.users;
	}

	@Override
	public User createNew(User user) {
		return saveAndReturn(user);
	}

	@Override
	public User save(Long id, User user) {
        user.setId(id);
        return saveAndReturn(user);
	}

	@Override
	public User patch(Long id, User user) {
		User savedUser = getById(id);
		if(user.getName() != null && !user.getName().isEmpty()) {
			savedUser.setName(user.getName());
		}
		if(user.getPassword() != null && !user.getPassword().isEmpty()) {
			savedUser.setPassword(user.getPassword());
		}
		if(user.getActive() != null) {
			savedUser.setActive(user.getActive());
		}
		return saveAndReturn(savedUser);
	}

	@Override
	public void deleteById(Long id) {
		this.users.removeIf(user -> user.getId().equals(id));
	}
	
	private User saveAndReturn(User user) {
		if(user.getId() != null) {
			User savedUser = getById(user.getId());
			this.users.set(this.users.indexOf(savedUser), user);
		} else {
			actualId++;
			user.setId(actualId);
			this.users.add(user);
		}
        
        return user;
    }
}
