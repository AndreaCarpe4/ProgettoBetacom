package com.betacom.bec.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.bec.models.Carrello;
import com.betacom.bec.models.Utente;

public interface CarrelloRepository extends JpaRepository<Carrello, Integer> {
	
    
    //Optional<Carrello> findByUtenteId(Integer utenteId);
    
    //List<Carrello> getByUtenteId(Integer utenteId);

    @Query(name = "carrello.quantita")
    Integer getQuantitaTotale(@Param("carrelloId") Integer carrelloId);

    @Query(name = "carrello.prezzo")
    Double getPrezzoTotale(@Param("carrelloId") Integer carrelloId);
    
    @Query(name = "carrello.lista")
    List<Carrello> getByUtenteId(@Param("utenteId") Integer utenteId);

	List<Carrello> getByUtenteId(int utenteId);

	Optional<Carrello> findByUtente(Utente utente);
    
	@Query(name = "utente.username")
	Optional<Carrello> findByUserNameWithCarrello(@Param("userName") String userName);
	
	List<Carrello> findByUtenteId(Integer utenteId);


}