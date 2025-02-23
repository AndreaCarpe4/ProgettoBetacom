package com.betacom.fe.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.dto.ProdottoDTO;
import com.betacom.fe.response.ResponseList;

@Controller
public class ControllerAccessori {

	@Autowired
	RestTemplate rest;
	
	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	Logger log;
	
	@GetMapping("/accessori")
	public ModelAndView showDonnapage() {
	    ModelAndView accessori = new ModelAndView("accessori");

	    URI uri = UriComponentsBuilder.fromUriString(backend + "prodotto/listByCategoria/accessori").build().toUri();
	    System.out.println("Uri: " + uri);

	    ResponseList<ProdottoDTO> responseList = rest.getForEntity(uri, ResponseList.class).getBody();

	    accessori.addObject("listProdotti", responseList);

	    return accessori;
	}
	
}