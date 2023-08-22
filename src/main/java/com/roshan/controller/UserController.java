package com.roshan.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roshan.entity.User;
import com.roshan.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<Page<User>> findAllUsers(Pageable pageable){
		return new ResponseEntity<Page<User>>(userService.listAllUsers(pageable),HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username){
		return ResponseEntity.ok(userService.getUserByUsername(username));
	}
	
	@GetMapping("/first-name/{firstName}")
	public ResponseEntity<List<User>> getUsersByFirstName(@PathVariable String firstName){
		return new ResponseEntity<List<User>>(userService.getUsersByFirstName(firstName),HttpStatus.OK);
	}
	
	@GetMapping("/last-name/{lastName}")
	public ResponseEntity<List<User>> getUsersByLastName(@PathVariable String lastName){
		return new ResponseEntity<List<User>>(userService.getUsersByLastName(lastName),HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email){
		return ResponseEntity.ok(userService.getUserByEmail(email));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable UUID id,@RequestBody User newUser){
		return new ResponseEntity<User>(userService.updateUser(id, newUser),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable UUID id){
		return ResponseEntity.ok(userService.deleteUser(id));
	}

}
