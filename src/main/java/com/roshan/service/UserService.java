package com.roshan.service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.roshan.entity.User;
import com.roshan.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Page<User> listAllUsers(Pageable pageable){
		return userRepository.findAll(pageable);
	}
	
	public User addUser(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> getUsersByFirstName(String firstName){
		return userRepository.findByFirstName(firstName);
	}
	
	public List<User> getUsersByLastName(String lastName){
		return userRepository.findByLastName(lastName);
	}
	
	public User getUserByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public User updateUser(UUID id,User newUser) {
		User oldUser = userRepository.findById(id).orElse(null);
		if (!newUser.getFirstName().isBlank()) {
			oldUser.setFirstName(newUser.getFirstName());
		}
//		oldUser.setFirstName(newUser.getFirstName());
		oldUser.setLastName(newUser.getLastName());
		oldUser.setDateOfBirth(newUser.getDateOfBirth());
		oldUser.setEmail(newUser.getEmail());
		oldUser.setUsername(newUser.getUsername());
		return userRepository.saveAndFlush(oldUser);
	}
	
	public User deleteUser(UUID id) {
		userRepository.deleteById(id);
		return null;
	}

}
