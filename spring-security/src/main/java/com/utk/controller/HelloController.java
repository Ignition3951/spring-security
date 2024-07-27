package com.utk.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String helloController(Authentication authentication) {
		return "Hello " + authentication.getName() + "  !!!!";
	}
}
