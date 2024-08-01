package com.utk.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utk.service.NameService;

@Controller
public class MainController {

	@Autowired
	private NameService nameService;

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

	@GetMapping("/secret/names/{name}")
	@ResponseBody
	public List<String> names(@PathVariable String name) {
		return nameService.getSecretNames(name);
	}
}
