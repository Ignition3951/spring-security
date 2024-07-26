package com.utk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

//	@Bean
//	UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		String password = encoder.encode("password");
//		User user = (User) User.withUsername("utkarsh").password(password).authorities("read").build();
//		return new InMemoryUserDetailsManager(user);
//	}
//
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Autowired
	private CustomAuthenticationProvider authenticationProvider;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic(Customizer.withDefaults());
		httpSecurity.authenticationProvider(authenticationProvider);
		httpSecurity.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
		return httpSecurity.build();
	}

	public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}
}
