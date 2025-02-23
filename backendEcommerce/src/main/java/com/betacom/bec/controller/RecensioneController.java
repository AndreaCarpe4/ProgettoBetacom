	package com.betacom.bec.controller;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;
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
	    org.slf4j.Logger log;
	    
	    @PostMapping("/create")
	    public ResponseBase create(@RequestBody RecensioneReq req) {
	        log.debug("create: " + req);
	        ResponseBase r = new ResponseBase();
	        r.setRc(true);
	        try {
	            recensioneS.create(req);
	        } catch (Exception e) {
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