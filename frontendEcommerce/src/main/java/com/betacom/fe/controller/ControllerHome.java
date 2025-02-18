package com.betacom.fe.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerHome {

	@Autowired
	RestTemplate rest;
	
	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	Logger log;
	
	@GetMapping("/home")
	public ModelAndView showHomepage() {
		
		ModelAndView home = new ModelAndView("homepage");
		
		return home;
		
	}
	
}
