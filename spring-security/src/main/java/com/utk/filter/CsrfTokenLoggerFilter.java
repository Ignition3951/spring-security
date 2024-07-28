package com.utk.filter;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.web.csrf.CsrfToken;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class CsrfTokenLoggerFilter implements Filter {

	private final Logger logger = (Logger) LogManager.getLogger(CsrfTokenLoggerFilter.class.getName());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");

		logger.info("CSRF TOKEN IS : " + csrfToken.getToken());

		chain.doFilter(request, response);
	}

}
