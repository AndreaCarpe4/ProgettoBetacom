package com.betacom.bec.services.implementations;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.betacom.bec.models.Carrello;
import com.betacom.bec.models.Prodotto;
import com.betacom.bec.models.Utente;
import com.betacom.bec.repositories.CarrelloRepository;
import com.betacom.bec.repositories.ProdottoRepository;
import com.betacom.bec.repositories.UtenteRepository;
import com.betacom.bec.services.interfaces.CarrelloServices;

public class CarrelloImpl implements CarrelloServices{

	@Autowired
	CarrelloRepository carR;
	
	@Autowired
    private ProdottoRepository prodottoRepository;
    @Autowired
    private UtenteRepository utenteRepository;
	
	@Autowired
	Logger log;

	@Override
    public Carrello aggiungiProdotto(int utenteId, int prodottoId, int quantita) {
        Utente utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        Prodotto prodotto = prodottoRepository.findById(prodottoId)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));

        Carrello carrello = new Carrello();
        carrello.setUtente(utente);
        carrello.setProdotto(prodotto);
        carrello.setQuantita(quantita);
        return carR.save(carrello);
    }

    @Override
    public void rimuoviProdotto(int carrelloId) {
    	carR.deleteById(carrelloId);
    }

    @Override
    public Carrello aggiornaQuantita(int carrelloId, int quantita) {
        Carrello carrello = carR.findById(carrelloId)
                .orElseThrow(() -> new RuntimeException("Elemento nel carrello non trovato"));
        carrello.setQuantita(quantita);
        return carR.save(carrello);
    }

    @Override
    public List<Carrello> ottieniCarrello(int utenteId) {
        return carR.findByUtenteId(utenteId);
    }
	
	
	
	
}
