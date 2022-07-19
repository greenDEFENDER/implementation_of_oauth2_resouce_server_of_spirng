package com.abhay.resourceserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ResourceServerSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests().antMatchers(HttpMethod.GET, "/api/user").
		hasAuthority("SCOPE_USER")
				.antMatchers(HttpMethod.GET, "/api/otheruser").hasAuthority("SCOPE_ADMIN").anyRequest().authenticated()
				.and().oauth2ResourceServer().jwt();
	}

}
