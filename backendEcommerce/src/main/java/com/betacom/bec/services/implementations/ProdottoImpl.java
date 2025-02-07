package com.betacom.bec.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.bec.dto.ProdottoDTO;
import com.betacom.bec.models.Carrello;
import com.betacom.bec.models.Prodotto;
import com.betacom.bec.repositories.ProdottoRepository;
import com.betacom.bec.request.ProdottoReq;
import com.betacom.bec.services.interfaces.ProdottoServices;

@Service
public class ProdottoImpl implements ProdottoServices{

	@Autowired
	ProdottoRepository proR;
	
	@Autowired
	Logger log;
	
	@Override
    public void create(ProdottoReq req) throws Exception {
        log.debug("Creazione prodotto: " + req);

        Optional<Prodotto> existingProdotto = proR.findByNome(req.getNome().trim());

        if (existingProdotto.isPresent()) {
            throw new Exception("Prodotto già presente");
        }

        Prodotto prodotto = new Prodotto();
        prodotto.setMarca(req.getMarca());
        prodotto.setNome(req.getNome());
        prodotto.setCategoria(req.getCategoria());
        prodotto.setDescrizione(req.getDescrizione());
        prodotto.setPrezzo(req.getPrezzo());
        prodotto.setQuantitaDisponibile(req.getquantitaDisponibile());
        prodotto.setUrlImg(req.getUrlImg());
        prodotto.setSize(req.getSize());
        prodotto.setColore(req.getColore());
        prodotto.setDataCreazione(req.getDataCreazione());

        proR.save(prodotto);
        log.debug("Prodotto salvato con successo");
    }
	

	@Override
	public List<ProdottoDTO> listByCategoria(String categoria) {
	    List<Prodotto> prodotti = proR.findByCategoria(categoria);
	    return prodotti.stream().map(ProdottoDTO::new).collect(Collectors.toList());
	}

	
	
	
	
	
	
}
