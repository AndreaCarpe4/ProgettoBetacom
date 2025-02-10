package com.betacom.bec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.bec.models.Carrello;
import com.betacom.bec.models.CarrelloProdotto;
import com.betacom.bec.models.Prodotto;

public interface CarrelloProdottoRepository extends JpaRepository<CarrelloProdotto, Integer> {

	CarrelloProdotto findByCarrelloAndProdotto(Carrello carrello, Prodotto prodotto);

	

}
