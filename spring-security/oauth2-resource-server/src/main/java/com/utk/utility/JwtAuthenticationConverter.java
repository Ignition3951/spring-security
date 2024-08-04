package com.utk.utility;

import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import com.utk.model.CustomAuthenticationToken;

@Component
public class JwtAuthenticationConverter implements Converter<Jwt, CustomAuthenticationToken> {

	@Override
	public CustomAuthenticationToken convert(Jwt source) {
		List<GrantedAuthority> authorities = List.of(() -> "read");
		String priority = String.valueOf(source.getClaims().get("priority"));
		return new CustomAuthenticationToken(source, authorities, priority);
	}

}
