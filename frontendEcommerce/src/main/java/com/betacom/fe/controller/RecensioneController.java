package com.betacom.fe.controller;

import java.net.URI;
import java.security.Principal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.dto.PagamentoDTO;
import com.betacom.fe.dto.RecensioneDTO;
import com.betacom.fe.request.ProdottoReq;
import com.betacom.fe.request.RecensioneReq;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseList;

@Controller
public class RecensioneController {
	
	 @Autowired
	    RestTemplate rest;

	    @Value("${jpa.backend}")
	    String backend;

	    @Autowired
	    Logger log;
	    
//	    @GetMapping("/createRecensione")
//	    public ModelAndView listByUserId(@RequestParam(required = false) String utenteId, Principal principal) {
//	        ModelAndView pagamentoPage = new ModelAndView("creaRecensione");
//
//	        try {
//	            // Se l'ID non è passato come parametro, recuperalo dal nome utente
//	            if (utenteId == null) {
//	                utenteId = principal.getName();
//	            }
//
//	            // Recupera l'ID dell'utente usando il nome
//	            Integer userId = getUserIdByUsername(utenteId);
//
//	            if (userId == null) {
//	                pagamentoPage.addObject("error", "Impossibile recuperare l'ID dell'utente.");
//	                return pagamentoPage;
//	            }
//
//	            // Ottieni l'ID del prodotto dalla richiesta
//	            //Integer prodottoId = /* ottieni l'ID del prodotto (da parametro o altro) */;
//
//	            // Chiamata per verificare se l'utente ha acquistato il prodotto
//	            URI uriAcquisto = UriComponentsBuilder
//	                    .fromUriString(backend + "recensione/haAcquistato")
//	                    .queryParam("utenteId", userId)
//	                    .queryParam("prodottoId", prodottoId)
//	                    .build().toUri();
//
//	            ResponseEntity<ResponseBase> responseAcquistoEntity = rest.getForEntity(uriAcquisto, ResponseBase.class);
//	            ResponseBase responseAcquisto = responseAcquistoEntity.getBody();
//
//	            // Controllo se l'utente ha acquistato il prodotto
//	            if (responseAcquisto != null && responseAcquisto.getRc()) {
//	                // Se ha acquistato, consenti di creare la recensione
//	                // Visualizza il modulo per la recensione (o altre informazioni)
//	                pagamentoPage.addObject("puoiScrivereRecensione", true);
//	            } else {
//	                // Se non ha acquistato, mostra il messaggio
//	                pagamentoPage.addObject("error", "Acquista il prodotto prima di lasciare una recensione.");
//	            }
//
//	        } catch (Exception e) {
//	            log.error("Errore nel recupero delle informazioni della recensione: ", e);
//	            pagamentoPage.addObject("error", "Si è verificato un errore durante il recupero delle informazioni.");
//	        }
//
//	        return pagamentoPage;
//	    }

	   
	    
	    private Integer getUserIdByUsername(String username) {
	        try {
	            URI uri = UriComponentsBuilder
	                    .fromUriString(backend + "utente/listByUsername")
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
	    
	    

}
