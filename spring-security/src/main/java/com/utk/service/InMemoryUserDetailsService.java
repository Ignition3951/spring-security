package com.utk.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class InMemoryUserDetailsService implements UserDetailsService {

	private List<UserDetails> userDetails;

	public InMemoryUserDetailsService(List<UserDetails> userDetails) {
		super();
		this.userDetails = userDetails;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDetails.stream().filter(u -> u.getUsername().equals(username)).findFirst()
				.orElseThrow(() -> new UsernameNotFoundException("User is not found!!!!"));
	}

}
