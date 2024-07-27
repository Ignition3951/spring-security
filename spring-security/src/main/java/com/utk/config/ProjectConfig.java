package com.utk.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.utk.model.User;
import com.utk.service.InMemoryUserDetailsService;

@Configuration
public class ProjectConfig {

	@Bean
	UserDetailsService userDetailsService(PasswordEncoder encoder) {
		String password = encoder.encode("password");
		UserDetails user = new User("utk1311", password, "read");
		List<UserDetails> userDetails = List.of(user);
		return new InMemoryUserDetailsService(userDetails);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Autowired
//	private CustomAuthenticationProvider authenticationProvider;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic(Customizer.withDefaults());
		// httpSecurity.authenticationProvider(authenticationProvider);
		httpSecurity.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
		return httpSecurity.build();
	}

//	public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
//		this.authenticationProvider = authenticationProvider;
//	}
}
