package com.sonndc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonndc.common.ResultResponse;
import com.sonndc.security.service.UserDetailsImpl;
import com.sonndc.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/profile")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<ResultResponse> getUserProfile(Authentication authentication) {
		Long userId = ((UserDetailsImpl) authentication.getPrincipal()).getId();
		return ResponseEntity.ok(userService.getUserProfile(userId));
	}
	
	
}