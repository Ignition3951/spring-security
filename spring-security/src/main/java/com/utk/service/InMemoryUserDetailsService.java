package com.utk.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.utk.model.User;

@Service
public class InMemoryUserDetailsService implements UserDetailsService {

	private List<UserDetails> userDetails;

	public InMemoryUserDetailsService(List<UserDetails> userDetails) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = bCryptPasswordEncoder.encode("12345");
		UserDetails user = new User("utk1311", password, "read");
		List<UserDetails> users = List.of(user);
		userDetails = users;
		this.userDetails = userDetails;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("userDetails : " + userDetails.toString());
		return userDetails.stream().filter(u -> u.getUsername().equals(username)).findFirst()
				.orElseThrow(() -> new UsernameNotFoundException("User is not found!!!!"));
	}

}
