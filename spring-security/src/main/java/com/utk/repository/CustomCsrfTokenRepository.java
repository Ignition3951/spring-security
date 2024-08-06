package com.utk.repository;

import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Repository;

import com.utk.model.Token;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Repository
public class CustomCsrfTokenRepository implements CsrfTokenRepository {

	private final Logger logger = LogManager.getLogger(CustomCsrfTokenRepository.class.getName());

	@Autowired
	private JpaTokenRepository jpaTokenRepository;

	@Override
	public CsrfToken generateToken(HttpServletRequest request) {
		String uuid = UUID.randomUUID().toString();
		return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid);
	}

	@Override
	public void saveToken(CsrfToken csrfToken, HttpServletRequest request, HttpServletResponse response) {

		String identifier = request.getHeader("X-IDENTIFIER");
		logger.info("X-IDENTIFIER of the header is " + identifier);
		Optional<Token> existingToken = jpaTokenRepository.findTokenByIdentifier(identifier);

		if (existingToken.isPresent()) {
			Token token = existingToken.get();
			token.setToken(csrfToken.getToken());
		} else {
			Token token = new Token();
			token.setToken(csrfToken.getToken());
			token.setIdentifier(identifier);
			jpaTokenRepository.save(token);
		}
	}

	@Override
	public CsrfToken loadToken(HttpServletRequest request) {
		String identifier = request.getHeader("X-IDENTIFIER");
		logger.info("X-IDENTIFIER of the header is " + identifier);
		Optional<Token> existingToken = jpaTokenRepository.findTokenByIdentifier(identifier);
		logger.info("Existing Token is " + existingToken);
		if (existingToken.isPresent()) {
			Token token = existingToken.get();
			return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", token.getToken());
		}

		return null;
	}

}
