package com.sonndc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonndc.common.ResultResponse;
import com.sonndc.service.PostService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping
	public ResponseEntity<ResultResponse> getAllPost() {
		return ResponseEntity.ok(postService.getAllPost());
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<ResultResponse> getPost(@PathVariable (name = "postId") Long postId) {
		return ResponseEntity.ok(postService.getPost(postId));
	}
	
}