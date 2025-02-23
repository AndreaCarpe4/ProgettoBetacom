package com.betacom.bec.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.betacom.bec.dto.UtenteDTO;
import com.betacom.bec.models.Carrello;
import com.betacom.bec.request.UtenteReq;



public interface UtenteServices {


	void create(UtenteReq req) throws Exception;

	List<UtenteDTO> list();

	void remove(UtenteReq req) throws Exception;

	void update(UtenteReq req) throws Exception;

	UtenteDTO findById(Integer id) throws Exception;

	UtenteDTO findByUsername(String userName) throws Exception;

	Optional<Carrello> findCarrelloByUserName(String userName);
}