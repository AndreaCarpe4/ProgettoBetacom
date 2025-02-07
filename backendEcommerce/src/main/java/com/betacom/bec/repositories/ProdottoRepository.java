package com.betacom.bec.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.bec.models.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer>{

	Optional<Prodotto> findByNome(String nome);
	
	List<Prodotto> findByCategoria(String categoria);

}
