package com.utk.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

	private final Logger logger = LogManager.getLogger(ProductController.class.getName());

	@PostMapping("/add")
	public String add(@RequestParam String name) {
		logger.info("Successfully added " + name);
		return "main.html";
	}
}
