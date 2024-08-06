package com.utk.service;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class NameService {

	private final Logger logger = LogManager.getLogger(NameService.class.getName());

	private Map<String, List<String>> map = Map.of("utk1311", List.of("Energico", "Perfecto"), "john",
			List.of("Fantastico"));

	@PreAuthorize("#name == authentication.name")
	public List<String> getSecretNames(String name) {
		logger.info("getSecretNames called");
		return map.get(name);
	}
}
