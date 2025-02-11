package com.betacom.bec.services.interfaces;

import java.util.List;

import com.betacom.bec.dto.UtenteDTO;
import com.betacom.bec.request.UtenteReq;

public interface UtenteServices {
	
	List<UtenteDTO> listAll();

	void create(UtenteReq req) throws Exception;

	void update(UtenteReq req);

	void remove(UtenteReq req);

}