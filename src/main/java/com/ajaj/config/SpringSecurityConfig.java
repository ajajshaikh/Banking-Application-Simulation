package com.ajaj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuth custauth;

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(custauth);
		auth.inMemoryAuthentication().withUser("ajaj").password("ajaj").roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic().and().authorizeRequests()
				.antMatchers("/login", "/app-login", "/login-failure", "/register", "/forgot-password").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/")
				.failureUrl("/login-failure").and().logout().logoutUrl("/app-logout").logoutSuccessUrl("/login");
	}

}
