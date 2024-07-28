package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.formLogin(Customizer.withDefaults());
		// httpSecurity.formLogin(c -> c.defaultSuccessUrl("/home", true));
		// httpSecurity.addFilterBefore(new RequestValidationFilter(),
		// BasicAuthenticationFilter.class);
		// httpSecurity.addFilterAfter(new AuthenticationLoggingFilter(),
		// BasicAuthenticationFilter.class);
		httpSecurity.httpBasic(Customizer.withDefaults());
		// httpSecurity.authenticationProvider(customAuthenticationProvider);
		// httpSecurity.authorizeHttpRequests(requests ->
		// requests.anyRequest().authenticated());
		// httpSecurity.authorizeHttpRequests(requests ->
		// requests.anyRequest().hasAuthority("write"));
//		httpSecurity.authorizeHttpRequests(requests -> requests.anyRequest().hasRole("ADMIN"));
		httpSecurity.authorizeHttpRequests(requests -> requests.requestMatchers("/home").hasRole("ADMIN")
				.requestMatchers("/caio").hasRole("MANAGER").anyRequest().permitAll());
		return httpSecurity.build();
	}
}
