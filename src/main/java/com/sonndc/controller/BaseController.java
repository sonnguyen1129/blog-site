package com.sonndc.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class BaseController {

	protected String getCurrentLoginUserName() throws Exception {
		Authentication userAuthentication = SecurityContextHolder.getContext().getAuthentication();
		if (userAuthentication == null) {
			return "Authentication not found!";
		}

		Object principal = userAuthentication.getPrincipal();

		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}

}
