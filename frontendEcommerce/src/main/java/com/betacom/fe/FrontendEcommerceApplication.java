package com.betacom.fe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FrontendEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontendEcommerceApplication.class, args);
	}
	
	@Bean
	RestTemplate rest() {
		
		RestTemplate rt = new RestTemplateBuilder().build();
		return rt;
		
	}
	
	@Bean
	@Scope("prototype")
	Logger logger(InjectionPoint ip) {
		
		return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
		
	}
	
	
}
