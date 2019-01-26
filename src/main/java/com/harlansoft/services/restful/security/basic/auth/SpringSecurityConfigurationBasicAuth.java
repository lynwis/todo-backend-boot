package com.harlansoft.services.restful.security.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration			// tells Spring that this file contains configuration
@EnableWebSecurity		// tells Spring that this files concerns web security policies
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()		// prevents cross site request forgery
			.authorizeRequests()
//	allows pre-flight requests (OPTIONS) to any URL
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//	in this way we are allowing EVERY OPTIONS request, unauthenticated
//	this is needed to permit basic auth (the auth request is first sent via OPTIONS method)
				.anyRequest().authenticated()	// every other request is accepted if authenticated
				.and()
//			.formLogin().and()					// form based auth disabled
			.httpBasic();						// allows basic auth
	}
	
}
