package com.roshan.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue(generator = "uuid")
	private UUID id;
	@NotEmpty
	@Column(unique = true)
	private String username;
	@NotEmpty
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;
	@NotNull
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

}
