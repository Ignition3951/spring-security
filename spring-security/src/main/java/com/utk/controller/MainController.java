package com.utk.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	private final Logger logger = LogManager.getLogger(MainController.class.getName());

	@GetMapping("/main")
	public String mainController() {
		return "main";
	}

	@GetMapping("/homes")
	public String homesController() {
		return "home";
	}

	@PostMapping("/test")
	@ResponseBody
	@CrossOrigin("http://localhost:8081")
	public String test() {
		logger.info("Test method called");
		return "HELLO";
	}
}
