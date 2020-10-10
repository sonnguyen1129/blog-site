package com.sonndc.security.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonndc.common.MessageResponse;
import com.sonndc.common.ResultResponse;
import com.sonndc.data.ERole;
import com.sonndc.entity.RoleEntity;
import com.sonndc.entity.UserEntity;
import com.sonndc.repository.RoleRepository;
import com.sonndc.repository.UserRepository;
import com.sonndc.security.jwt.JwtUtils;
import com.sonndc.security.payload.request.LoginRequest;
import com.sonndc.security.payload.request.SignUpRequest;
import com.sonndc.security.payload.response.JwtResponse;
import com.sonndc.security.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/sign-in")
	public ResponseEntity<ResultResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername().trim(), loginRequest.getPassword().trim()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(ResultResponse.SUCCESS.withData(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles)));
	}

	@PostMapping("/sign-up")
	public ResponseEntity<ResultResponse> registerUser(@RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.ok(ResultResponse.FAILED.withMessage(MessageResponse.USER_ALREADY_EXIST));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.ok(ResultResponse.FAILED.withMessage(MessageResponse.EMAIL_ALREADY_EXIST));
		}

		// Create new user's account
		UserEntity user = new UserEntity(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<RoleEntity> roles = new HashSet<>();

		if (strRoles == null) {
			RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					RoleEntity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					RoleEntity modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(ResultResponse.FAILED.withMessage(MessageResponse.REGISTER_SUCCESS));
	}
	
	@PostMapping("/default")
	public ResponseEntity<ResultResponse> addDefaultDB() {
		List<ERole> listERole = new ArrayList<>();
		listERole.add(ERole.ROLE_USER);
		listERole.add(ERole.ROLE_MODERATOR);
		listERole.add(ERole.ROLE_ADMIN);
		for (ERole eRole : listERole) {
			if (!roleRepository.findByName(eRole).isPresent()) {
				RoleEntity role = new RoleEntity();
				role.setName(eRole);
				roleRepository.save(role);
			}
		}
		return ResponseEntity.ok(ResultResponse.SUCCESS);
	}
}