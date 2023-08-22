package com.roshan.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.roshan.entity.User;
import com.roshan.exception.DuplicateEmailException;
import com.roshan.exception.DuplicateUsernameException;
import com.roshan.exception.InvalidDateOfBirthException;
import com.roshan.exception.UserNotFoundException;
import com.roshan.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Page<User> listAllUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public User addUser(User user) throws DuplicateEmailException, DuplicateUsernameException, InvalidDateOfBirthException {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new DuplicateEmailException("Email address already Used");
		}
		else if (userRepository.existsByUsername(user.getUsername())) {
			throw new DuplicateUsernameException("Username already used");
		}
		else if (user.getDateOfBirth().isAfter(LocalDate.now())) {
			throw new InvalidDateOfBirthException("Future date cannot be date of birth");
		}else {
			return userRepository.saveAndFlush(user);
		}

	}

	public User getUserByUsername(String username) throws UserNotFoundException {
		if (userRepository.existsByUsername(username)) {
			return userRepository.findByUsername(username);
		} else {
			throw new UserNotFoundException("User not Found");
		}
	}

	public Page<User> getUsersByFirstName(String firstName, Pageable pageable) {
		return userRepository.findByFirstName(firstName, pageable);
	}

	public Page<User> getUsersByLastName(String lastName, Pageable pageable) {
		return userRepository.findByLastName(lastName, pageable);
	}

	public User getUserByEmail(String email) throws UserNotFoundException {
		if (userRepository.existsByEmail(email)) {
			return userRepository.findByEmail(email);
		} else {
			throw new UserNotFoundException("User not Found");
		}
	}

	public User updateUser(UUID id, User newUser) throws UserNotFoundException, InvalidDateOfBirthException {
		User oldUser = userRepository.findById(id).orElse(null);
		if (oldUser != null) {
			if (newUser.getDateOfBirth().isAfter(LocalDate.now())) {
				throw new InvalidDateOfBirthException("Future date cannot be date of birth");
			}
			oldUser.setFirstName(newUser.getFirstName());
			oldUser.setLastName(newUser.getLastName());
			oldUser.setDateOfBirth(newUser.getDateOfBirth());
			oldUser.setEmail(newUser.getEmail());
			oldUser.setUsername(newUser.getUsername());
			return userRepository.saveAndFlush(oldUser);
		}else {
			throw new UserNotFoundException("User not Found");
		}
	}

	public User deleteUser(UUID id) throws UserNotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
		userRepository.deleteById(id);
		return user;
	}

}
