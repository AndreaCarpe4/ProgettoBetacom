package com.betacom.bec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.betacom.bec.services.interfaces.PagamentoServices;
import com.betacom.bec.models.Pagamento;
import com.betacom.bec.request.PagamentoReq;
import com.betacom.bec.response.ResponseBase;
import com.betacom.bec.response.ResponseList;

@RestController
@RequestMapping("/rest/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoServices pagamentoS;

    @Autowired
    org.slf4j.Logger log;

    // Metodo per creare un pagamento
    @PostMapping("/create")
    public ResponseBase create(@RequestBody PagamentoReq req) {
        log.debug("create: " + req);
        ResponseBase r = new ResponseBase();
        r.setRc(true);
        try {
            pagamentoS.create(req);
        } catch (Exception e) {
            r.setMsg(e.getMessage());
            r.setRc(false);
        }
        return r;
    }

    // Metodo per ottenere i pagamenti di un utente
    @GetMapping("/listByUser/{userId}")
    public ResponseList<Pagamento> listByUser(@PathVariable Integer userId) {
        log.debug("Lista dei pagamenti per l'utente con ID: " + userId);
        ResponseList<Pagamento> r = new ResponseList<>();
        try {
            r.setDati(pagamentoS.getPagamentiByUserId(userId));
            r.setRc(true);
        } catch (Exception e) {
            log.error("Errore nel recupero dei pagamenti: ", e);
            r.setMsg(e.getMessage());
            r.setRc(false);
        }
        return r;
    }

    // Metodo per rimuovere un pagamento
    @PostMapping("/remove")
    public ResponseBase remove(@RequestBody PagamentoReq req) {
        log.debug("remove: " + req);
        ResponseBase r = new ResponseBase();
        r.setRc(true);
        try {
            pagamentoS.removePagamento(req);
        } catch (Exception e) {
            r.setMsg(e.getMessage());
            r.setRc(false);
        }
        return r;
    }
    
    @PostMapping("/update")
    public ResponseBase update(@RequestBody PagamentoReq req) {
        log.debug("update: " + req);
        ResponseBase r = new ResponseBase();
        r.setRc(true);
        try {
            pagamentoS.update(req);
        } catch (Exception e) {
            r.setMsg(e.getMessage());
            r.setRc(false);
        }
        return r;
    }
}