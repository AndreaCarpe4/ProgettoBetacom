package com.betacom.fe.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.dto.CarrelloDTO;
import com.betacom.fe.dto.ProdottoDTO;
import com.betacom.fe.response.ResponseList;

@Controller
public class CarrelloController {
	
	@Autowired
	RestTemplate rest;
	
	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	Logger log;
	
	@GetMapping("/carrello")
    public ModelAndView showCarrelloPage(@RequestParam int idutente) {
        ModelAndView carrelloPage = new ModelAndView("carrello"); // Nome della vista Thymeleaf: carrello.html

        try {
            URI uri = UriComponentsBuilder.fromUriString(backend + "/lista?idutente=" + idutente).build().toUri();
            log.debug("Chiamata a URI: " + uri);

            // Chiama il backend per ottenere i dati del carrello
            ResponseList<CarrelloDTO> responseList = rest.getForObject(uri, ResponseList.class);

            if (responseList != null && responseList.getRc()) {
                carrelloPage.addObject("listCarrelli", responseList.getDati());
            } else {
                carrelloPage.addObject("error", "Errore nel recupero del carrello.");
            }
        } catch (Exception e) {
            log.error("Errore nel recupero del carrello", e);
            carrelloPage.addObject("error", "Si è verificato un errore durante il recupero del carrello.");
        }

        return carrelloPage;
    }



}
