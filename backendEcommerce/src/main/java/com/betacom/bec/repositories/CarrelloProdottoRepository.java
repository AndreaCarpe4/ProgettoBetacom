package com.betacom.bec.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.bec.models.Carrello;
import com.betacom.bec.models.CarrelloProdotto;
import com.betacom.bec.models.Prodotto;

import jakarta.transaction.Transactional;

public interface CarrelloProdottoRepository extends JpaRepository<CarrelloProdotto, Integer> {

	Optional<CarrelloProdotto> findByCarrelloAndProdotto(Carrello carrello, Prodotto prodotto);

    @Modifying
    @Transactional
    @Query(name = "carrello.delete")
    void rimuoviProdottoDalCarrello(@Param("carrelloId") Integer carrelloId, @Param("prodottoId") Integer prodottoId);

	Optional<CarrelloProdotto> findByCarrelloIdAndProdottoId(int carrelloId, int prodottoId);

	List<CarrelloProdotto> findByProdotto(Prodotto prodotto);

}