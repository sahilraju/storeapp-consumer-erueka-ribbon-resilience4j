package com.mphasis;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	
	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}

} 
 