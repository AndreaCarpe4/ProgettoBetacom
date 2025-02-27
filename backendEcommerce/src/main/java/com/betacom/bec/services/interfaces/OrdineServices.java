package com.betacom.bec.services.interfaces;

import java.util.List;

import com.betacom.bec.dto.OrdineDTO;
import com.betacom.bec.request.OrdineReq;

public interface OrdineServices  {

	List<OrdineDTO> listByUtente(Integer idUtente);

	void create(OrdineReq req) throws Exception;

	List<OrdineDTO> listOrdiniConUtente();

	List<OrdineDTO> list();

}