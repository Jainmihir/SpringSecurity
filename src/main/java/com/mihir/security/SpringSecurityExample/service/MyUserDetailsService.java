package com.mihir.security.SpringSecurityExample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import com.mihir.security.SpringSecurityExample.Model.UserModel;
import com.mihir.security.SpringSecurityExample.Model.UserPrincipal;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mihir.security.SpringSecurityExample.Repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel user = repo.findByUsername(username);
		if(user == null) {
			System.out.print("User not found " );
			throw new UsernameNotFoundException("user not found ");
		}
		
		return new UserPrincipal(user);
	}
	
	
}
