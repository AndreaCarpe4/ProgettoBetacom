package com.betacom.bec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.bec.dto.ProdottoDTO;
import com.betacom.bec.request.ProdottoReq;
import com.betacom.bec.response.ResponseBase;
import com.betacom.bec.response.ResponseList;
import com.betacom.bec.services.interfaces.ProdottoServices;


@RestController
@RequestMapping("/rest/prodotto")
public class ProdottoController {
	
	@Autowired
	ProdottoServices prodottoS;
	
	@Autowired
	org.slf4j.Logger log;
	
	@PostMapping("/create")
    public ResponseBase create(@RequestBody ProdottoReq req) {
        log.debug("Creazione prodotto: " + req);
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


}
