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

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class);
		httpSecurity.addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class);
		httpSecurity.httpBasic(Customizer.withDefaults());
		// httpSecurity.authenticationProvider(customAuthenticationProvider);
		httpSecurity.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
		return httpSecurity.build();
	}
}
