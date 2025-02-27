	package com.betacom.bec.controller;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

import com.betacom.bec.services.interfaces.OrdineServices;
import com.betacom.bec.services.interfaces.RecensioneServices;
	import com.betacom.bec.dto.RecensioneDTO;
	import com.betacom.bec.request.RecensioneReq;
	import com.betacom.bec.response.ResponseBase;
	import com.betacom.bec.response.ResponseList;
	
	@RestController
	@RequestMapping("/rest/recensione")
	public class RecensioneController {
	    
	    @Autowired
	    RecensioneServices recensioneS;
	    
	    @Autowired
	    OrdineServices ordineS;
	    
	    @Autowired
	    org.slf4j.Logger log;
	    
	    @PostMapping("/create")
	    public ResponseBase create(@RequestBody RecensioneReq req) {
	        log.debug("create: " + req);
	        ResponseBase r = new ResponseBase();
	        
	        try {
	            // Chiamata al servizio per creare la recensione
	            recensioneS.create(req);
	            r.setRc(true);
	            r.setMsg("Recensione creata con successo.");
	        } catch (Exception e) {
	            log.error("Errore nella creazione della recensione: ", e);
	            r.setMsg(e.getMessage()); // Messaggio d'errore restituibile
	            r.setRc(false);
	        }
	        
	        return r;
	    }

	    
	    @GetMapping("/haAcquistato")
	    public ResponseBase haAcquistato(@RequestParam Integer utenteId, @RequestParam Integer prodottoId) {
	        ResponseBase r = new ResponseBase();
	        try {
	            log.debug("Controllo acquisto per utenteId: " + utenteId + " e prodottoId: " + prodottoId);
	            
	            // Chiamata al metodo haAcquistatoProdotto di OrdineServices
	            boolean haAcquistato = recensioneS.haAcquistato(utenteId, prodottoId);

	            log.debug("Ha acquistato risultato: " + haAcquistato);
	            r.setRc(haAcquistato);
	        } catch (Exception e) {
	            log.error("Errore nel controllo di acquisto: ", e);
	            r.setMsg(e.getMessage());
	            r.setRc(false);
	        }
	        return r;
	    }

	    
	    @PostMapping("/update")
	    public ResponseBase update(@RequestBody RecensioneReq req) {
	        log.debug("update: " + req);
	        ResponseBase r = new ResponseBase();
	        r.setRc(true);
	        try {
	            recensioneS.update(req);
	        } catch (Exception e) {
	            r.setMsg(e.getMessage());
	            r.setRc(false);
	        }
	        return r;
	    }
	    
	    @GetMapping("/listAll")
	    public ResponseList<RecensioneDTO> listAll() {
	        ResponseList<RecensioneDTO> r = new ResponseList<>();
	        try {
	            r.setDati(recensioneS.listAllRecensioni());
	            r.setRc(true);
	        } catch (Exception e) {
	            log.error("Errore nel recupero delle recensioni: ", e);
	            r.setMsg(e.getMessage());
	            r.setRc(false);
	        }
	        return r;
	    }
	    
	    @PostMapping("/remove")
	    public ResponseBase remove(@RequestBody RecensioneReq req) {
	        log.debug("delete: " + req);
	        ResponseBase r = new ResponseBase();
	        r.setRc(true);
	        try {
	            recensioneS.removeRecensione(req);
	        } catch (Exception e) {
	            r.setMsg(e.getMessage());
	            r.setRc(false);
	        }
	        return r;
	    }
	    
		@GetMapping("/listByProdotto")
		public ResponseList<RecensioneDTO> listByProdotto(@RequestParam("id") Integer idProdotto) {
			log.debug("List " + idProdotto);
			ResponseList<RecensioneDTO> r = new ResponseList<RecensioneDTO>();
			r.setRc(true);
			try {
				r.setDati(recensioneS.listByProdotto(idProdotto));
			} catch (Exception e) {
				log.debug(e.getMessage());
				r.setMsg(e.getMessage());
				r.setRc(false);
			}
			return r;
			
		}
		
	}