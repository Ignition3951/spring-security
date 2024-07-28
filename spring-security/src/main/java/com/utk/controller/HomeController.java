package com.utk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String homeController() {
		return "home.html";
	}

	@GetMapping("/error")
	public String errorController() {
		return "Error.html";
	}

	@GetMapping("/caio")
	public String caioController() {
		return "home.html";
	}

	@GetMapping("/hola")
	public String holaController() {
		return "home.html";
	}
}
