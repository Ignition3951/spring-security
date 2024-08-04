package com.utk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.utk.utility.JwtAuthenticationConverter;

@Configuration
public class ProjectConfig {

	@Value("${keySetURI}")
	private String keySetURI;

	private JwtAuthenticationConverter authenticationConverter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.oauth2ResourceServer(
				c -> c.jwt(j -> j.jwkSetUri(keySetURI).jwtAuthenticationConverter(authenticationConverter)));
		httpSecurity.authorizeHttpRequests(r -> r.anyRequest().authenticated());
		return httpSecurity.build();
	}
}
