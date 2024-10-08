package com.mihir.security.SpringSecurityExample.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		// disabling CSRF
		http.csrf(customizer -> customizer.disable());

		// enabling authentication
		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		// for form login
		http.formLogin(Customizer.withDefaults());
		// for postman use
		http.httpBasic(Customizer.withDefaults());

		// for every time refresh new sessionId
		// if you check on browser then you can remove the form login
		// for postman we use both
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// behind the scene without Lambda expression
		// this method is for csrf disabling
		// customizer is a functional interface so we used functional interface
		// Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new
		// Customizer<CsrfConfigurer<HttpSecurity>>() {
		//
		// @Override
		// public void customize(CsrfConfigurer<HttpSecurity> t) {
		// t.disable();
		//
		// }
		// };
		//
		// http.csrf(custCsrf);
		//

		// we can also use builder method
//		http
//			.csrf(customizer -> customizer.disable())
//			.authorizeHttpRequests(request -> request.anyRequest().authenticated());

		return http.build();
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		// for database interaction we have dao authentication provider
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		// password encoder : bcrypt the password
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		
		// userDetailsService : we are using bcz of username and password not choose
		// the default one he choose the implemented userdetailsservice 
		provider.setUserDetailsService(userDetailsService);
		
		return provider;
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails user1 = User.withDefaultPasswordEncoder().username("mihir").password("123").roles("USER").build();
//		UserDetails user2 = User.withDefaultPasswordEncoder().username("mj").password("123").roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user1,user2);
//		
//	}

}
