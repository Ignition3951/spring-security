//package com.utk.config;
//
//import java.util.Arrays;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//
//@Configuration
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		String username = authentication.getName();
//		String credentials = String.valueOf(authentication.getCredentials());
//		if ("utkarsh".equals(username) && "password123".equals(credentials)) {
//			return new UsernamePasswordAuthenticationToken(username, credentials, Arrays.asList());
//		} else {
//			throw new AuthenticationCredentialsNotFoundException("Kindly check the credentials!!!!!!");
//		}
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//	}
//
//}
