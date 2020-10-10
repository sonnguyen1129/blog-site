package com.sonndc.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.sonndc.Application;

public class ApplicationWebXml extends SpringBootServletInitializer {
	 
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	     return application.sources(Application.class);
	  }
	}