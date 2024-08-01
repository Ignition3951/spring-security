package com.utk.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class NameService {

	private Map<String, List<String>> map = Map.of("utk1311", List.of("Energico", "Perfecto"), "john",
			List.of("Fantastico"));

	@PreAuthorize("#name == authentication.name")
	public List<String> getSecretNames(String name) {
		return map.get(name);
	}
}
