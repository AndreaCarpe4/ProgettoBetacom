package com.betacom.bec.services.interfaces;

import java.util.List;

import com.betacom.bec.dto.RecensioneDTO;
import com.betacom.bec.models.Recensione;
import com.betacom.bec.request.RecensioneReq;

public interface RecensioneServices {

	void create(RecensioneReq req) throws Exception;

	void update(RecensioneReq req) throws Exception;

	void removeRecensione(RecensioneReq req) throws Exception;

	List<RecensioneDTO> listAllRecensioni() throws Exception;

	List<RecensioneDTO> listByProdotto(Integer idProdotto);
}