package com.sonndc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post")
public class PostEntity extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String summary;
	
	@NotBlank
	private String img;
	
	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@NotBlank
	private Long views;
	
	@NotBlank
	private Long showState;
	
	@NotBlank
	private String userId;
	
	@NotBlank
	private String category;
	
}
