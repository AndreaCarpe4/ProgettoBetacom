package com.betacom.bec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.bec.models.Ordine;
import com.betacom.bec.models.Prodotto;
import com.betacom.bec.models.Utente;

public interface OrdineRepository extends JpaRepository<Ordine, Integer> {
	
	List<Ordine> findByCarrelloId(Integer idCarrello);

	
	@Query(name = "recensione.utente")
	boolean existsByUtenteAndProdotto(@Param("utente") Utente utente, @Param("prodotto") Prodotto prodotto);


}