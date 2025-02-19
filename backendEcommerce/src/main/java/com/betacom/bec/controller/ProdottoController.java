package com.betacom.bec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.bec.services.interfaces.ProdottoServices;
import com.betacom.bec.dto.ProdottoDTO;
import com.betacom.bec.request.ProdottoReq;
import com.betacom.bec.response.ResponseBase;
import com.betacom.bec.response.ResponseList;
import com.betacom.bec.response.ResponseObject;

@RestController
@RequestMapping("/rest/prodotto")
public class ProdottoController {
	
	@Autowired
	ProdottoServices prodottoS;
	
	@Autowired
	org.slf4j.Logger log;
	

	
	@PostMapping("/create")
	public ResponseBase create(@RequestBody (required = true) ProdottoReq req) {
		log.debug("create: " + req);
		ResponseBase r = new ResponseBase();
		r.setRc(true);
		try {
			prodottoS.create(req);
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			r.setRc(false);
		}
		return r;
	}
	
	@PostMapping("/update")
	public ResponseBase update(@RequestBody (required = true) ProdottoReq req) {
		log.debug("update: " + req);
		ResponseBase r = new ResponseBase();
		r.setRc(true);
		try {
			
			prodottoS.update(req);
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			r.setRc(false);
		}
		return r;
	}

	@GetMapping("/listByCategoria/{categoria}")
    public ResponseList<ProdottoDTO> listByCategoria(@PathVariable String categoria) {
        log.debug("Lista prodotti per categoria: " + categoria);
        ResponseList<ProdottoDTO> r = new ResponseList<ProdottoDTO>();
        try {
            r.setDati(prodottoS.listByCategoria(categoria));
            r.setRc(true);
        } catch (Exception e) {
            log.error("Errore nel recupero dei prodotti per categoria: ", e);
            r.setMsg(e.getMessage());
            r.setRc(false);
        }
        return r;
    }
	
	@PostMapping("/remove")
	public ResponseBase remove(@RequestBody (required = true) ProdottoReq req) {
		log.debug("delete: " + req);
		ResponseBase r = new ResponseBase();
		r.setRc(true);
		try {
			prodottoS.removeProdotto(req);
		} catch (Exception e) {
			r.setMsg(e.getMessage());
			r.setRc(false);
		}
		return r;
	}
	
	@GetMapping("/{id}")
	public ResponseObject<ProdottoDTO> getProdottoById(@PathVariable Integer id) {
	    
	    log.debug("Inizio getProdottoById per il prodotto con ID: " + id);
	    
	    ResponseObject<ProdottoDTO> r = new ResponseObject<>();
	    
	    try {
	        
	        ProdottoDTO prodotto = prodottoS.findById(id);
	        
	        r.setRc(true);
	        r.setDati(prodotto);
	        
	    } catch (Exception e) {
	        log.error("Errore durante il recupero del prodotto con ID: " + id, e);
	        r.setRc(false);
	        r.setMsg("Si è verificato un errore durante il recupero del prodotto: " + e.getMessage());
	    }
	    
	    return r;
	}



}