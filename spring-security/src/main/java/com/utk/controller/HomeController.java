package com.utk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String homeController() {
		return "home.html";
	}

	@GetMapping("/error")
	public String errorController() {
		return "Error.html";
	}
}
