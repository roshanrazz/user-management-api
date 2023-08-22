package com.roshan.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.roshan.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	
	Page<User> findAll(Pageable pageable);

	User findByUsername(String username);

	List<User> findByFirstName(String firstName);

	List<User> findByLastName(String lastName);

	User findByEmail(String email);

}
