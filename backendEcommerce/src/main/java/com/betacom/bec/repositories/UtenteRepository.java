package com.betacom.bec.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.bec.models.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer>{
	
	Optional<Utente> findByNome(String trim);

	Optional<Utente> findById(Utente utenteId);

}