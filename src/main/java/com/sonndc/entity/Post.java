package com.sonndc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String summary;
	
	@NotBlank
	private String img;
	
	@NotBlank
	private String dateCreated;
	
	@NotBlank
	private String content;
	
	@NotBlank
	private Integer views;
	
	@NotBlank
	private Integer showState;
	
	@NotBlank
	private String userId;
	
	@NotBlank
	private String category;
	
}
