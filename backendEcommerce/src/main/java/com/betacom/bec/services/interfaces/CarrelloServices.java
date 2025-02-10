package com.betacom.bec.services.interfaces;

import java.util.List;

import com.betacom.bec.models.Carrello;

public interface CarrelloServices {
	
	Carrello aggiungiProdotto(int utenteId, int prodottoId, int quantita);
    void rimuoviProdotto(int carrelloId);
    Carrello aggiornaQuantita(int carrelloId, int quantita);
    List<Carrello> ottieniCarrello(int utenteId);

}
