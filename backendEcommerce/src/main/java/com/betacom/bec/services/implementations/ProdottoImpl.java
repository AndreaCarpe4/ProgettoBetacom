package com.betacom.bec.services.implementations;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.betacom.bec.models.Carrello;
import com.betacom.bec.models.Prodotto;
import com.betacom.bec.repositories.ProdottoRepository;
import com.betacom.bec.request.ProdottoReq;
import com.betacom.bec.services.interfaces.ProdottoServices;

public class ProdottoImpl implements ProdottoServices{

	@Autowired
	ProdottoRepository proR;
	
	@Autowired
	Logger log;
	
	// Creazione prodotto che finirà nella pagina di tutti i prodotti
	// pensare alla possibilità di creare un prodotto che poi verrà inserito all'interno della categoria 
	// specifica per quel prodotto -> se creo prodotto da uomo, deve finire sulla pagina prodotti uomo 

	@Override
	public void create(ProdottoReq req) throws Exception {
		
		System.out.println("Create : " + req);
		
		Optional<Prodotto> c = proR.findByNome(req.getNome().trim());
		
		if(c.isPresent())
			throw new Exception("Prodotto già presente");
		
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

      // Salva la Macchina
		proR.save(prodotto);
		
	}
	
	
	
	
	
	
}
