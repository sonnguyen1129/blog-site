package com.sonndc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonndc.common.MessageResponse;
import com.sonndc.common.ModelMapperUtils;
import com.sonndc.common.ResultResponse;
import com.sonndc.entity.UserEntity;
import com.sonndc.repository.UserRepository;
import com.sonndc.response.UserResponse;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public ResultResponse getUserProfile(Long id) {
		Optional<UserEntity> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			UserResponse userResponse = new UserResponse();
			ModelMapperUtils.map(userOptional.get(), userResponse);
			return ResultResponse.SUCCESS.withData(userResponse);
		}
		else 
			return ResultResponse.FAILED.withMessage(MessageResponse.USER_NOT_FOUND);
	}
	
}