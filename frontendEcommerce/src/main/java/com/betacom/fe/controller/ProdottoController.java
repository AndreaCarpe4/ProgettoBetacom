package com.betacom.fe.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.dto.ProdottoDTO;
import com.betacom.fe.response.ResponseList;

@Controller
public class ProdottoController {
	
	
	@Autowired
	RestTemplate rest;
	
	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	Logger log;
	
	
	@GetMapping("/prodotto/{id}")
	public ModelAndView dettaglioProdotto(@PathVariable Long id) {
		
	    ModelAndView mav = new ModelAndView("dettagliprodotto");

	    URI uri = UriComponentsBuilder.fromUriString(backend + "prodotto/" + id).build().toUri();
	    ResponseEntity<ProdottoDTO> response = rest.getForEntity(uri, ProdottoDTO.class);
	    
	    mav.addObject("prodotto", response.getBody());  

	    return mav;
	}
	

}
