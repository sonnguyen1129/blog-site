package com.sonndc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonndc.common.ModelMapperUtils;
import com.sonndc.common.ResultResponse;
import com.sonndc.entity.PostEntity;
import com.sonndc.repository.PostRepository;
import com.sonndc.response.PostResponse;

@Service
public class PostService {
	@Autowired
	PostRepository postRepository;
	
	public ResultResponse getAllPost() {
		return ResultResponse.SUCCESS.withData(ModelMapperUtils.mapAll(postRepository.findAll(), PostResponse.class));
	}
	
	public ResultResponse getPost(Long postId) {
		Optional<PostEntity> post = postRepository.findById(postId);
		if (post.isPresent()) {
			return ResultResponse.SUCCESS.withData(ModelMapperUtils.map(post.get(), PostResponse.class)) ;
		}
		else 
			return ResultResponse.NOT_FOUND;
	}
	
}