package com.roshan.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.roshan.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	
	Page<User> findAll(Pageable pageable);

	User findByUsername(String username);

	Page<User> findByFirstName(String firstName,Pageable pageable);

	Page<User> findByLastName(String lastName,Pageable pageable);

	User findByEmail(String email);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

}
