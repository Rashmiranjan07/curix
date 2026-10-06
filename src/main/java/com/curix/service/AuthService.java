package com.curix.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.curix.dto.RegistrationRequest;
import com.curix.entity.User;
import com.curix.enums.Role;
import com.curix.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public User register(RegistrationRequest request) {

		// 1. Check whether email already exists
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("Email is already registered");
		}

		// 2. Create User entity
		User user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
				.email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Role.PATIENT)
				.build();

		// 3. Save user into database
		return userRepository.save(user);
	}
}