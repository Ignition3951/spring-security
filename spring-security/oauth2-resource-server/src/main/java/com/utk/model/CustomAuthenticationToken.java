package com.utk.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class CustomAuthenticationToken extends JwtAuthenticationToken {

	private String priority;

	public String getPriority() {
		return priority;
	}

	public CustomAuthenticationToken(Jwt jwt, Collection<? extends GrantedAuthority> authorities, String priority) {
		super(jwt, authorities);
		this.priority = priority;
	}

}
