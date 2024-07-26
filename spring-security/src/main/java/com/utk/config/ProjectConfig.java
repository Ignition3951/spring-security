package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

	@Bean
	UserDetailsService userDetailsService() {
		User user = (User) User.withUsername("utkarsh").password("password").authorities("read").build();
		return new InMemoryUserDetailsManager(user);
	}
}
