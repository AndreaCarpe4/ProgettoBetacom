package com.betacom.bec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	
	
	@GetMapping("/listById")
	public ResponseObject<ProdottoDTO> listById(@RequestParam("id") Integer id) {
		log.debug("List " + id);
		ResponseObject<ProdottoDTO> r = new ResponseObject<ProdottoDTO>();
		r.setRc(true);
		List<ProdottoDTO> resp = null;
		try {
			r.setDati (prodottoS.findById(id));
		} catch (Exception e) {
			log.debug(e.getMessage());
			r.setMsg(e.getMessage());
			r.setRc(false);
		}
		return r;
		
	}
	
	@GetMapping("/list")
	public ResponseList<ProdottoDTO> list() {
		log.debug("List ");
		ResponseList<ProdottoDTO> r = new ResponseList<ProdottoDTO>();
		r.setRc(true);
		try {
			r.setDati (prodottoS.list());
		} catch (Exception e) {
			log.debug(e.getMessage());
			r.setMsg(e.getMessage());
			r.setRc(false);
		}
		return r;
		
	}



}