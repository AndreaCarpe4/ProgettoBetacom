package com.betacom.fe.controller;

import static com.betacom.fe.utilities.WebUtils.convertInObject;

import java.net.URI;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.dto.ProdottoDTO;
import com.betacom.fe.dto.UtenteDTO;
import com.betacom.fe.request.ProdottoReq;
import com.betacom.fe.request.UtenteReq;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseObject;

@Controller
public class ProdottoController {
	
	
	@Autowired
	RestTemplate rest;
	
	@Value("${jpa.backend}")
	String backend;
	
	@Autowired
	Logger log;
	
	
	
	@GetMapping("/listById")
	public ModelAndView dettaglioProdotto(@RequestParam Integer id) {
	    
	    ModelAndView mav = new ModelAndView("dettagliprodotto");

	    URI uri = UriComponentsBuilder
	            .fromUriString(backend + "prodotto/listById")
	            .queryParam("id", id)
	            .buildAndExpand().toUri();

	    log.debug("URI: " + uri);

	    ResponseEntity<ResponseObject> responseEntity = rest.getForEntity(uri, ResponseObject.class);
	    ResponseObject<?> responseObject = responseEntity.getBody();
	    
	    if (responseObject != null && responseObject.getDati() != null) {
	        mav.addObject("prodotto", responseObject.getDati());
	    } else {
	        mav.addObject("prodotto", null);
	    }

	    return mav;
	}
	
	 @GetMapping("/createProdotto") 
	    public ModelAndView createProdotto() {
	        ModelAndView mav = new ModelAndView("createProdotto");
	        mav.addObject("req", new ProdottoReq());
	        mav.addObject("errorMsg", null);
	        return mav;
	    }
	    
	    @PostMapping("/saveProdotto")
	    public Object saveProdotto(@ModelAttribute ProdottoReq req) {
	    	
	        log.debug("saveProdotto " + req);
	        
	        URI uri = UriComponentsBuilder.fromUriString(backend + "prodotto/create").build().toUri();
	        
	        ResponseBase rc = rest.postForEntity(uri, req, ResponseBase.class).getBody();
	        
	        log.debug("rc " + rc.getRc());
	        
	        if(!rc.getRc()) {
	        	
	        	ModelAndView mav = new ModelAndView("createProdotto");
	        	
	        	mav.addObject("req", new ProdottoReq());
	        	
	        	mav.addObject("errorMessage", rc.getMsg());
	        	
	        	return mav;
	        	
	        }
	        
	        return "redirect:/admin/listProdotti";
	        
	    }
	    
	    
	    
	    
	    @GetMapping("/updateProdotto")
	    public ModelAndView updateProdotto(@RequestParam Integer id) {
	        ModelAndView mav = new ModelAndView("updateProdotto");
	        
	        // Chiamata al backend per ottenere il prodotto tramite l'ID
	        URI uri = UriComponentsBuilder.fromUriString(backend + "prodotto/listById?id=" + id).build().toUri();
	        ResponseObject<ProdottoDTO> response = rest.getForEntity(uri, ResponseObject.class).getBody();
	        
	        // Aggiungi l'oggetto prodotto alla vista
	        mav.addObject("prodotto", response.getDati());
	        
	        return mav;
	    }


	    
	    @PostMapping("/saveUpdateProdotto")
	    public Object saveUpdateProdotto(@ModelAttribute ProdottoReq prodotto) {
	      
	        URI uri = UriComponentsBuilder.fromUriString(backend + "prodotto/update").build().toUri();
	        ResponseBase response = rest.postForEntity(uri, prodotto, ResponseBase.class).getBody();
	        
	        if (!response.getRc()) {
	            ModelAndView mav = new ModelAndView("updateProdotto");
	            mav.addObject("prodotto", prodotto);
	            mav.addObject("errorMsg", response.getMsg());
	            return mav;            
	        }
	        
	        return "redirect:/admin/listProdotti";
	    }

	    

	
	

}