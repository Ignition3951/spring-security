package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//		http.oauth2Login(Customizer.withDefaults());
		http.oauth2Client(Customizer.withDefaults());
		http.authorizeHttpRequests(c -> c.anyRequest().permitAll());
		return http.build();
	}

	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		ClientRegistration c1 = ClientRegistration.withRegistrationId("1").clientId("client").clientSecret("secret")
				.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
				.tokenUri("http://127.0.0.1:8081/oauth2/token").scope(OidcScopes.OPENID).build();
		return new InMemoryClientRegistrationRepository(c1);
	}

	@Bean
	public OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager(
			ClientRegistrationRepository clientRegistrationRepository,
			OAuth2AuthorizedClientRepository auth2AuthorizedClientRepository) {

		var provider = OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build();
		var cm = new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository,
				auth2AuthorizedClientRepository);

		cm.setAuthorizedClientProvider(provider);
		return cm;
	}


}
