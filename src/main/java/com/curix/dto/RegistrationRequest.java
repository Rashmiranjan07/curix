package com.curix.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {

	@NotBlank(message = "First name is required")
	private String firstName;

	@NotBlank(message = "Last name is required")
	private String lastName;

	@NotBlank(message = "Email is required")
	@Email(message = "Enter a valid email address")
	private String email;

	@NotBlank(message = "Password is required")
	@Size(min = 8, message = "Password must contain at least 8 characters")
	private String password;
}