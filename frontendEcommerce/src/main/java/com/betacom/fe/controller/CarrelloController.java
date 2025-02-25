package com.betacom.fe.controller;

import java.net.URI;
import java.security.Principal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.dto.CarrelloDTO;
import com.betacom.fe.dto.ProdottoDTO;
import com.betacom.fe.request.CarrelloReq;
import com.betacom.fe.request.ProdottoReq;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseList;
import com.betacom.fe.response.ResponseObject;

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
	    ModelAndView carrelloPage = new ModelAndView("carrello"); 

	    try {
	        // Se l'ID non è passato come parametro, recuperalo dal nome utente
	        if (utenteId == null) {
	            utenteId = principal.getName();
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

	    return carrelloPage; 
	}



	private Integer getUserIdByUsername(String username) {
	    try {
	        URI uri = UriComponentsBuilder
	                .fromUriString(backend + "utente/carrelloByUsername")
	                .queryParam("userName", username)
	                .build().toUri();

	        log.debug("Recupero ID per utente: " + username);

	        HashMap<String, Object> userResponse = rest.getForObject(uri, HashMap.class);

	        // Verifica se i dati sono validi e restituisci l'ID utente
	        if (userResponse != null && userResponse.containsKey("dati")) {
	            HashMap<String, Object> dati = (HashMap<String, Object>) userResponse.get("dati");
	            HashMap<String, Object> utente = (HashMap<String, Object>) dati.get("utente");
	            return (Integer) utente.get("id");  // Ottieni l'ID utente
	        }
	        
	        return null;
	    } catch (Exception e) {
	        log.error("Errore nel recupero dell'ID utente", e);
	        return null;
	    }
	}


	@GetMapping("/rimuovi")
	public Object removeProdotto(@RequestParam int carrelloId, @RequestParam int prodottoId, @RequestParam int quantitaDaRimuovere) {

	    URI uri = UriComponentsBuilder
	            .fromUriString(backend + "carrello/rimuovi")
	            .queryParam("carrelloId", carrelloId)
	            .queryParam("prodottoId", prodottoId)
	            .queryParam("quantitaDaRimuovere", quantitaDaRimuovere)
	            .build()
	            .toUri();

	    CarrelloReq req = new CarrelloReq();
	    req.setId(carrelloId);
	    req.setIdProdotto(prodottoId);
	    req.setQuantita(quantitaDaRimuovere);

	    ResponseBase rc = rest.postForEntity(uri, req, ResponseBase.class).getBody();

	    if (!rc.getRc()) {
	        ModelAndView mav = new ModelAndView("carrello");
	        mav.addObject("errorMessage", rc.getMsg());
	        return mav;
	    }

	    return "redirect:/carrello";
	}
	
	@GetMapping("/aggiungi")
	public Object aggiungiProdotto(@RequestParam int prodottoId, @RequestParam int quantita, Principal principal) {

	    try {
	        // Recupera l'ID utente dal nome utente
	        String username = principal.getName();
	        Integer userId = getUserIdByUsername(username); 

	        if (userId == null) {
	            ModelAndView mav = new ModelAndView("carrello");
	            mav.addObject("errorMessage", "Impossibile recuperare l'ID dell'utente.");
	            return mav;
	        }

	        // Usa direttamente l'ID utente come ID carrello
	        Integer carrelloId = userId;

	        URI uri = UriComponentsBuilder
	                .fromUriString(backend + "carrello/aggiungi")
	                .queryParam("carrelloId", carrelloId)
	                .queryParam("prodottoId", prodottoId)
	                .queryParam("quantita", quantita)
	                .build()
	                .toUri();

	        CarrelloReq req = new CarrelloReq();
	        req.setId(carrelloId);
	        req.setIdProdotto(prodottoId);
	        req.setQuantita(quantita);

	        ResponseBase rc = rest.postForEntity(uri, req, ResponseBase.class).getBody();

	        if (!rc.getRc()) {
	            ModelAndView mav = new ModelAndView("carrello");
	            mav.addObject("errorMessage", rc.getMsg());
	            return mav;
	        }

	        return "redirect:/carrello?utenteId=" + username;

	    } catch (Exception e) {
	        log.error("Errore nell'aggiunta del prodotto al carrello", e);
	        ModelAndView mav = new ModelAndView("carrello");
	        mav.addObject("errorMessage", "Si è verificato un errore durante l'aggiunta del prodotto al carrello.");
	        return mav;
	    }
	}

	


}