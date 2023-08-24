package com.roshan.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roshan.entity.User;
import com.roshan.exception.DuplicateEmailException;
import com.roshan.exception.DuplicateUsernameException;
import com.roshan.exception.InvalidDateOfBirthException;
import com.roshan.exception.UserNotFoundException;
import com.roshan.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("")
	public ResponseEntity<?> addUser(@RequestBody User user) throws DuplicateEmailException, DuplicateUsernameException, InvalidDateOfBirthException{
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("")
	public ResponseEntity<Page<User>> findAllUsers(Pageable pageable){
		return new ResponseEntity<Page<User>>(userService.listAllUsers(pageable),HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<?> getUserByUsername(@PathVariable String username) throws UserNotFoundException{
		return ResponseEntity.ok(userService.getUserByUsername(username));
		
	}
	
	@GetMapping("/first-name/{firstName}")
	public ResponseEntity<Page<User>> getUsersByFirstName(@PathVariable String firstName,Pageable pageable){
		return new ResponseEntity<Page<User>>(userService.getUsersByFirstName(firstName,pageable),HttpStatus.OK);
	}
	
	@GetMapping("/last-name/{lastName}")
	public ResponseEntity<Page<User>> getUsersByLastName(@PathVariable String lastName,Pageable pageable){
		return new ResponseEntity<Page<User>>(userService.getUsersByLastName(lastName,pageable),HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> getUserByEmail(@PathVariable String email) throws UserNotFoundException{
		return ResponseEntity.ok(userService.getUserByEmail(email));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable UUID id,@RequestBody User newUser) throws UserNotFoundException, InvalidDateOfBirthException{
		return new ResponseEntity<User>(userService.updateUser(id, newUser),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable UUID id) throws UserNotFoundException{
		return ResponseEntity.ok(userService.deleteUser(id));
	}

}
