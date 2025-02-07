package com.betacom.bec.services.interfaces;

import java.util.List;

import com.betacom.bec.dto.ProdottoDTO;
import com.betacom.bec.request.ProdottoReq;

public interface ProdottoServices {
	
	void create(ProdottoReq req) throws Exception;

	List<ProdottoDTO> listByCategoria(String categoria);

}
