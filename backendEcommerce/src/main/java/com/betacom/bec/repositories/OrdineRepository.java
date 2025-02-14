package com.betacom.bec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.bec.models.Ordine;
import com.betacom.bec.models.Prodotto;
import com.betacom.bec.models.Utente;

public interface OrdineRepository extends JpaRepository<Ordine, Integer> {
	
	List<Ordine> findByCarrelloId(Integer idCarrello);

	boolean existsByUtenteAndProdotto(Utente utente, Prodotto prodotto);

}
