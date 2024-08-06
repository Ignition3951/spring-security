package com.utk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private OAuth2AuthorizedClientManager clientManager;

	@GetMapping("/")
	public String home() {
		return "index.html";
	}

	@GetMapping("/token")
	public String token() {
		OAuth2AuthorizeRequest request = OAuth2AuthorizeRequest.withClientRegistrationId("1").principal("client")
				.build();
		var client = clientManager.authorize(request);
		return client.getAccessToken().getTokenValue();
	}
}
