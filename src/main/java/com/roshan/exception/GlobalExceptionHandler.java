package com.roshan.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(DuplicateUsernameException.class)
	public ResponseEntity<String> handleDuplicateUsernameException(DuplicateUsernameException ex){
		return ResponseEntity.badRequest().body(ex.getMessage()); 
	}
	
	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<String> handleDuplicateEmailException(DuplicateEmailException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(InvalidDateOfBirthException.class)
	public ResponseEntity<String> handleInavalidDateOfBirthException(InvalidDateOfBirthException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleException(Exception ex){
//		return ResponseEntity.internalServerError().body("Internal Server Error");
//	}
	
}
