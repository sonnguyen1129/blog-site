package com.sonndc.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {

	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	public MessageResponse() {
		super();
	}

	private String message;

	public static final String SUCCESS = "SUCCESS";
	public static final String UNKNOWN_FAILED = "UNKNOWN_FAILED";
	public static final String UNAUTHORIZED = "UNAUTHORIZED";
	public static final String FORBIDDEN = "FORBIDDEN";
	public static final String DATA_NOT_FOUND = "DATA_NOT_FOUND";
	public static final String NOT_SUPPORT = "NOT_SUPPORT";
	public static final String TOO_MANY_REQUEST = "TOO_MANY_REQUEST";
	
	public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
	public static final String USER_ALREADY_EXIST = "USER_ALREADY_EXIST";
	public static final String EMAIL_ALREADY_EXIST = "EMAIL_ALREADY_EXIST";
	public static final String REGISTER_SUCCESS = "REGISTER_SUCCESS";
}
