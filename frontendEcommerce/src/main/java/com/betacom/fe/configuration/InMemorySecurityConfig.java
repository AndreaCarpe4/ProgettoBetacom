//package com.betacom.fe.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class InMemorySecurityConfig {
//
//	@Autowired
//	CustomUserDetailsService customUserDetailsService;
//	
//	@Bean
//	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//		
//		return customUserDetailsService.loadUsers();
//		
//	}
//	
//	
//}
