package com.betacom.bec.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.bec.models.Utente;


public interface UtenteRepository extends JpaRepository<Utente, Integer>{
	
	Optional<Utente> findByUserName(String userName);


	Optional<Utente> findById(Utente utenteId);


}