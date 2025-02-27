package com.betacom.bec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.bec.models.Prodotto;
import com.betacom.bec.models.Recensione;
import com.betacom.bec.models.Utente;

public interface RecensioneRepository extends JpaRepository<Recensione, Integer> {

	List<Recensione> findByProdottoId(Integer idProdotto);

	boolean existsByUtenteAndProdotto(Utente utente, Prodotto prodotto);
	
	@Query(name = "recensione.haAcquistato")
    boolean haAcquistato(@Param("utenteId") Integer utenteId, @Param("prodottoId") Integer prodottoId);



}