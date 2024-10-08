package com.mihir.security.SpringSecurityExample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Greet {
	
	@GetMapping("/")
	public String greet(HttpServletRequest req) {
		// when you are logout the session id is gone
		// when you are login with new id the session id is different from previous
		// different users different session ID
		return "Hello World " + req.getSession().getId();
	}
	
	
	
	
	
	
	
}
