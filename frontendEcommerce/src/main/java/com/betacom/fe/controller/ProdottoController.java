package com.betacom.fe.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	
	@GetMapping("/listByCategoria/{categoria}")
	public ModelAndView listByCategoria(@PathVariable String categoria) {
	    ModelAndView mav = new ModelAndView("listProdotti");
	    
	    URI uri = UriComponentsBuilder.fromUriString(backend + "prodotto/listByCategoria/" + categoria).build().toUri();
	    System.out.println("Uri: " + uri);
	    
	    ResponseList<ProdottoDTO> responseList = rest.getForEntity(uri, ResponseList.class).getBody();
	    
	    mav.addObject("listProdotti", responseList);
	    
	    return mav;
	}
	

}
