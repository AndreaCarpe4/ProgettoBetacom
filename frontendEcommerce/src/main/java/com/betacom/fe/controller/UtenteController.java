package com.betacom.fe.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.betacom.fe.configuration.UtenteService;
import com.betacom.fe.dto.UtenteDTO;
import com.betacom.fe.request.UtenteReq;
import com.betacom.fe.response.ResponseBase;
import com.betacom.fe.response.ResponseObject;
import static com.betacom.fe.utilities.WebUtils.convertInObject;

@Controller
public class UtenteController {
    
    @Value("${jpa.backend}")
    String backend;
    
    @Autowired
    RestTemplate rest;
    
    @Autowired
    Logger log;
    
    @Autowired
    UtenteService utenteService;
    
    @GetMapping("/create") 
    public ModelAndView createUtente() {
        ModelAndView mav = new ModelAndView("registrazione");
        mav.addObject("req", new UtenteReq());
        mav.addObject("errorMsg", null);
        return mav;
    }
    
    @GetMapping("/profilo") 
    public ModelAndView profilo(@RequestParam String userName) {
        ModelAndView mav = new ModelAndView("profilo");
        
        URI uri = UriComponentsBuilder
                .fromUriString(backend + "utente/listByUsername") 
                .queryParam("userName", userName)
                .buildAndExpand().toUri();
        
        log.debug("URI: " + uri);
        
        ResponseObject<?> utRest = rest.getForEntity(uri, ResponseObject.class).getBody();
        UtenteDTO ut = (UtenteDTO) convertInObject(utRest.getDati(), UtenteDTO.class);
        
        UtenteReq u = new UtenteReq(
                ut.getId(),
                ut.getNome(),
                ut.getCognome(),
                ut.getEmail(),
                ut.getUserName(),
                ut.getPassword(),
                ut.getRuolo(),
                ut.getNumeroTelefono(),
                ut.getIndirizzoDiSpedizione(),
                ut.getIndirizzoDiFatturazione()
        );

        mav.addObject("utente", u);
        return mav;
    }
    
    
    
    @PostMapping("/save")
    public Object saveUtente(@ModelAttribute UtenteReq req) {
        log.debug("saveUtente " + req);
        
        String operation = (req.getId() == null) ? "create" : "update";
        
        URI uri = UriComponentsBuilder
                .fromUriString(backend + "utente/" + operation)
                .buildAndExpand().toUri();
        
        log.debug("URI: " + uri);
        
        ResponseBase r = rest.postForEntity(uri, req, ResponseBase.class).getBody();
        log.debug("rc: " + r.getRc());
        
        if (!r.getRc()) {
            ModelAndView mav = new ModelAndView("registrazione");
            mav.addObject("req", req);
            mav.addObject("errorMsg", r.getMsg());
            return mav;            
        }
        utenteService.updateUtente(req);
        
        return "redirect:/login";
    }
    
    @PostMapping("/saveUtente")
    public Object save(@ModelAttribute UtenteReq req) {
        log.debug("saveUtente " + req);
        
        String operation = (req.getId() == null) ? "create" : "update";
        
        URI uri = UriComponentsBuilder
                .fromUriString(backend + "utente/" + operation)
                .buildAndExpand().toUri();
        
        log.debug("URI: " + uri);
        
        ResponseBase r = rest.postForEntity(uri, req, ResponseBase.class).getBody();
        log.debug("rc: " + r.getRc());
        
        if (!r.getRc()) {
            ModelAndView mav = new ModelAndView("profilo");
            mav.addObject("utente", req);
            mav.addObject("errorMsg", r.getMsg());
            return mav;            
        }
        utenteService.updateUtente(req);
        
        return "redirect:/profilo?userName=" + req.getUserName();
    }
    
    @GetMapping("/update") 
    public ModelAndView updateUtente(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("registrazione");
        
        URI uri = UriComponentsBuilder
                .fromUriString(backend + "utente/listById") 
                .queryParam("id", id)
                .buildAndExpand().toUri();
        
        log.debug("URI: " + uri);
        
        ResponseObject<?> utRest = rest.getForEntity(uri, ResponseObject.class).getBody();
        UtenteDTO ut = (UtenteDTO) convertInObject(utRest.getDati(), UtenteDTO.class);
        
        UtenteReq u = new UtenteReq(
                ut.getId(),
                ut.getNome(),
                ut.getCognome(),
                ut.getEmail(),
                ut.getUserName(),
                ut.getPassword(),
                ut.getRuolo(),
                ut.getNumeroTelefono(),
                ut.getIndirizzoDiSpedizione(),
                ut.getIndirizzoDiFatturazione()
        );

        mav.addObject("req", u);
        return mav;
    }
}