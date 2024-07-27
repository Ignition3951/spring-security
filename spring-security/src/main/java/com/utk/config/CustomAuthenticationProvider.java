package com.utk.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.utk.service.InMemoryUserDetailsService;

@Configuration
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final Logger logger = LogManager.getLogger(CustomAuthenticationProvider.class.getName());

	@Autowired
	private InMemoryUserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String credentials = String.valueOf(authentication.getCredentials());
		logger.info("authentication username : " + username);

		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		logger.info("userDetails : " + userDetails.toString());
		return new UsernamePasswordAuthenticationToken(username, credentials, userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
