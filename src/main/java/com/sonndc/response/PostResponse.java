package com.sonndc.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponse {

	private String title;
	private String summary;
	private String img;
	private String content;
	private Long views;
	private Long showState;
	private String category;
	private Date createdDate;
	private Date updatedDate;

	public PostResponse() {
		super();
	}

}
