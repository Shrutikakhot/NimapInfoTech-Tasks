package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringwebConfig {
	@Bean
	public InMemoryUserDetailsManager userDetailsService()
	{
		
		UserDetails user=User.withDefaultPasswordEncoder()
				.username("Shrutika")
				.password("Shrutika123")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((authz)->authz
				.requestMatchers("/message")
				//.anyRequest()
				.authenticated() )
				.httpBasic();
		return http.build();
				
	}
}
