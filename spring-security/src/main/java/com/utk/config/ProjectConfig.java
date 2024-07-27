package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.utk.filter.AuthenticationLoggingFilter;
import com.utk.filter.RequestValidationFilter;

@Configuration
public class ProjectConfig {

//	@Autowired
//	private CustomAuthenticationProvider customAuthenticationProvider;

//	@Bean
//	UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		String password = encoder.encode("12345");
//		UserDetails user = new User("utk1311", password, "read");
//		List<UserDetails> userDetails = List.of(user);
//		return new InMemoryUserDetailsManager(userDetails);
//	}

//	@Bean
//	UserDetailsService userDetailsService(DataSource dataSource) {
//		String usersByUsernameQuery = "select username, password, enabled from users where username =  'john' ";
//		// String authByUsersQuery = "select username, authority from authorities where
//		// username = ?";
//		UserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//		manager.userExists(usersByUsernameQuery);
//		manager.loadUserByUsername(usersByUsernameQuery);
//		return manager;
//	}

//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

//	@Autowired
//	private CustomAuthenticationProvider authenticationProvider;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class);
		httpSecurity.addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class);
		httpSecurity.httpBasic(Customizer.withDefaults());
		// httpSecurity.authenticationProvider(customAuthenticationProvider);
		httpSecurity.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
		return httpSecurity.build();
	}

//	public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
//		this.authenticationProvider = authenticationProvider;
//	}
}
