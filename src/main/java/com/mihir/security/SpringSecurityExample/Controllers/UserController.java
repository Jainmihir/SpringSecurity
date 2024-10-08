package com.mihir.security.SpringSecurityExample.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mihir.security.SpringSecurityExample.Model.UserModel;
import com.mihir.security.SpringSecurityExample.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public UserModel registerUser(@RequestBody UserModel user) {
		return userService.registerUser(user);
	}
	
}
