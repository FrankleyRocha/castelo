package com.francalino.frankley.castelo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityConfig {

	private static final String GROUPS = "groups";
	private static final String REALM_ACCESS_CLAIM = "realm_access";
	private static final String ROLES_CLAIM = "roles";

	@Bean
	@Order(1)
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(a -> a.requestMatchers("/api/**").authenticated().anyRequest().permitAll());

		http.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));

		// http.oauth2Login(Customizer.withDefaults());

		/*
		 * mais em: - https://www.baeldung.com/spring-boot-keycloak -
		 * https://www.baeldung.com/postman-keycloak-endpoints -
		 * http://localhost:8080/realms/myrealm/.well-known/openid-configuration
		 */

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
	    return (web) -> web.ignoring().requestMatchers("/h2-console/**");
	}

	@Bean
	public GrantedAuthoritiesMapper userAuthoritiesMapperForKeycloak() {
		return authorities -> {
			Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
			var authority = authorities.iterator().next();
			boolean isOidc = authority instanceof OidcUserAuthority;

			if (isOidc) {
				var oidcUserAuthority = (OidcUserAuthority) authority;
				var userInfo = oidcUserAuthority.getUserInfo();

				// Tokens can be configured to return roles under
				// Groups or REALM ACCESS hence have to check both
				if (userInfo.hasClaim(REALM_ACCESS_CLAIM)) {
					var realmAccess = userInfo.getClaimAsMap(REALM_ACCESS_CLAIM);
					var roles = (Collection<String>) realmAccess.get(ROLES_CLAIM);
					mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles));
				} else if (userInfo.hasClaim(GROUPS)) {
					Collection<String> roles = (Collection<String>) userInfo.getClaim(GROUPS);
					mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles));
				}
			} else {
				var oauth2UserAuthority = (OAuth2UserAuthority) authority;
				Map<String, Object> userAttributes = oauth2UserAuthority.getAttributes();

				if (userAttributes.containsKey(REALM_ACCESS_CLAIM)) {
					Map<String, Object> realmAccess = (Map<String, Object>) userAttributes.get(REALM_ACCESS_CLAIM);
					Collection<String> roles = (Collection<String>) realmAccess.get(ROLES_CLAIM);
					mappedAuthorities.addAll(generateAuthoritiesFromClaim(roles));
				}
			}
			return mappedAuthorities;
		};
	}

	Collection<GrantedAuthority> generateAuthoritiesFromClaim(Collection<String> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
	}

}