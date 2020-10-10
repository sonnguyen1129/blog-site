package com.sonndc.common;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResultResponse {
	
	public static final int STATUS_SUCCESS = 200;
	
	public static final int STATUS_UNKNOWN_FAILED = 500;
	
	public static final int STATUS_UNAUTHORIZED = 401;

	public static final int STATUS_FORBIDDEN = 403;
	
	public static final int STATUS_NOT_FOUND = 404;

	public static final int STATUS_NOT_SUPPORT = 300;

	public static final int STATUS_TOO_MANY_REQUEST = 309;

	public static final ResultResponse SUCCESS = new ResultResponse(STATUS_SUCCESS, MessageResponse.SUCCESS);
	public static final ResultResponse FAILED = new ResultResponse(STATUS_UNKNOWN_FAILED, MessageResponse.UNKNOWN_FAILED);
	public static final ResultResponse UNAUTHORIZED = new ResultResponse(STATUS_UNAUTHORIZED, MessageResponse.UNAUTHORIZED);
	public static final ResultResponse FORBIDDEN = new ResultResponse(STATUS_FORBIDDEN, MessageResponse.FORBIDDEN);
	public static final ResultResponse NOT_FOUND = new ResultResponse(STATUS_NOT_FOUND, MessageResponse.DATA_NOT_FOUND);
	public static final ResultResponse TOO_MANY_REQUEST = new ResultResponse(STATUS_TOO_MANY_REQUEST, MessageResponse.TOO_MANY_REQUEST);

	public ResultResponse withData(Object data) {
		return new ResultResponse(status, message, data);
	}
	
	public ResultResponse withMessage(String message) {
		return new ResultResponse(null, message, null);
	}

	public ResultResponse(Integer status, String message) {
		this.status = status;
		this.message = message;
		this.data = null;
	}

	@NotNull
	private final Integer status;
	
	@NotNull
	private final String message;

	private final Object data;

}
