package com.betacom.fe.controller;

import java.net.URI;
import java.security.Principal;
import java.util.HashMap;

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
	public ModelAndView showCarrelloPage(@RequestParam(required = false) String utenteId, Principal principal) {
	    ModelAndView carrelloPage = new ModelAndView("carrello"); // Crea un nuovo ModelAndView con la vista "carrello"

	    try {
	        // Se l'ID non è passato come parametro, recuperalo dal nome utente
	        if (utenteId == null) {
	            utenteId = principal.getName();  // Usa il nome utente come fallback
	        }

	        // Recupera l'ID dell'utente usando il nome
	        Integer userId = getUserIdByUsername(utenteId);

	        if (userId == null) {
	            carrelloPage.addObject("error", "Impossibile recuperare l'ID dell'utente.");
	            return carrelloPage;
	        }

	        URI uri = UriComponentsBuilder
	                .fromUriString(backend + "carrello/lista")
	                .queryParam("utenteId", userId)  // Usa l'ID recuperato
	                .build().toUri();

	        log.debug("URI: " + uri);
	        

	        ResponseList<CarrelloDTO> responseList = rest.getForObject(uri, ResponseList.class);
	        log.debug("Carrelli: " + responseList.getDati());


	        if (responseList != null && responseList.getRc()) {
	            carrelloPage.addObject("listCarrelli", responseList.getDati());
	        } else {
	            carrelloPage.addObject("error", "Errore nel recupero del carrello.");
	        }
	    } catch (Exception e) {
	        log.error("Errore nel recupero del carrello", e);
	        carrelloPage.addObject("error", "Si è verificato un errore durante il recupero del carrello.");
	    }

	    return carrelloPage;  // Restituisci il ModelAndView con i dati
	}



	private Integer getUserIdByUsername(String username) {
	    try {
	        URI uri = UriComponentsBuilder
	                .fromUriString(backend + "utente/carrelloByUsername")
	                .queryParam("userName", username)
	                .build().toUri();

	        log.debug("Recupero ID per utente: " + username);

	        // Ottieni la risposta dal backend
	        HashMap<String, Object> userResponse = rest.getForObject(uri, HashMap.class);

	        // Verifica se i dati sono validi e restituisci l'ID utente
	        if (userResponse != null && userResponse.containsKey("dati")) {
	            HashMap<String, Object> dati = (HashMap<String, Object>) userResponse.get("dati");
	            HashMap<String, Object> utente = (HashMap<String, Object>) dati.get("utente");
	            return (Integer) utente.get("id");  // Ottieni l'ID utente
	        }
	        
	        return null; // In caso di errore o dati mancanti
	    } catch (Exception e) {
	        log.error("Errore nel recupero dell'ID utente", e);
	        return null;
	    }
	}




}