package com.security.appsecurity1.context_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppContextConfig {
    
	/*
	 * @Bean public UserDetailsService userDetailsService() { JpaUserDetailsService
	 * uds = new JpaUserDetailsService(); return uds; }
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
