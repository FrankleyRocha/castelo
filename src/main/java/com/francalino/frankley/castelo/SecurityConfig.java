package com.francalino.frankley.castelo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityConfig {

	@Bean
	@Order(1)
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {

		http
		.authorizeHttpRequests( a -> a			
			.requestMatchers("/api/**").authenticated()
			.requestMatchers("/**").permitAll()
		);
		
		http.oauth2ResourceServer(
			(oauth2) -> oauth2.jwt(Customizer.withDefaults())
		);
		
		//http.oauth2Login(Customizer.withDefaults());
		
		/* 
		 * mais em:
		 * - https://www.baeldung.com/spring-boot-keycloak
		 * - https://www.baeldung.com/postman-keycloak-endpoints
		 * - http://localhost:8080/realms/myrealm/.well-known/openid-configuration
		 */

		return http.build();
	}

}