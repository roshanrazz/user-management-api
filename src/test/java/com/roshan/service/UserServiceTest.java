package com.roshan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.roshan.entity.User;
import com.roshan.exception.DuplicateEmailException;
import com.roshan.exception.DuplicateUsernameException;
import com.roshan.exception.InvalidDateOfBirthException;
import com.roshan.repository.UserRepository;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	public void testAddUser() throws DuplicateEmailException, DuplicateUsernameException, InvalidDateOfBirthException {
		User user = new User(UUID.fromString("9db40a0c-a516-4207-92f7-5b2bc82bacf9"),"roshan123","Roshan","Sah","roshan@mail.com",LocalDate.of(2000, 02, 25));
		user.setId(UUID.fromString("9db40a0c-a516-4207-92f7-5b2bc82bacf9"));
		when(userRepository.saveAndFlush(user)).thenReturn(user);
        assertEquals(user, userService.addUser(user));
	}

}
