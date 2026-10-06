
package com.curix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.curix.dto.RegistrationRequest;
import com.curix.entity.User;
import com.curix.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<User> register(@Valid @RequestBody RegistrationRequest request) {

		User registeredUser = authService.register(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
	}
}
