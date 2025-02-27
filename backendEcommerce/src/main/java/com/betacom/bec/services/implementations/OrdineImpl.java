	package com.betacom.bec.services.implementations;

import static com.betacom.bec.utils.Utilities.buildCarrelloProdottoDTO;
import static com.betacom.bec.utils.Utilities.convertStringToDate;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.bec.dto.CarrelloDTO;
import com.betacom.bec.dto.OrdineDTO;
import com.betacom.bec.models.Carrello;
import com.betacom.bec.models.CarrelloProdotto;
import com.betacom.bec.models.Ordine;
import com.betacom.bec.models.OrdineProdotto;
import com.betacom.bec.models.Prodotto;
import com.betacom.bec.models.Utente;
import com.betacom.bec.repositories.CarrelloRepository;
import com.betacom.bec.repositories.OrdineRepository;
import com.betacom.bec.repositories.ProdottoRepository;
import com.betacom.bec.repositories.UtenteRepository;
import com.betacom.bec.request.OrdineReq;
import com.betacom.bec.services.interfaces.CarrelloServices;
import com.betacom.bec.services.interfaces.MessaggioServices;
import com.betacom.bec.services.interfaces.OrdineServices;

import jakarta.transaction.Transactional;


@Service
public class OrdineImpl implements OrdineServices{
	
	@Autowired
	OrdineRepository orR;
	
	@Autowired
	CarrelloRepository carR;
	
	@Autowired
	ProdottoRepository prodottoR;
	
	@Autowired
	CarrelloServices carS;
	
	@Autowired
	UtenteRepository utR;
	
	
	@Autowired
	private MessaggioServices msgS;
	
	@Autowired
	Logger log;
	
	@Override
	@Transactional
	public void create(OrdineReq req) throws Exception {
	    if (req.getIndirizzoDiSpedizione() == null || req.getIndirizzoDiSpedizione().isEmpty())
	        throw new Exception(msgS.getMessaggio("no-spedizione"));
	    if (req.getCap() == null || req.getCap().isEmpty())
	        throw new Exception(msgS.getMessaggio("no-cap"));
	    if (req.getCitta() == null || req.getCitta().isEmpty())
	        throw new Exception(msgS.getMessaggio("no-citta"));

	    Ordine ordine = new Ordine();
	    ordine.setIndirizzoDiSpedizione(req.getIndirizzoDiSpedizione());
	    ordine.setCap(req.getCap());
	    ordine.setCitta(req.getCitta());
	    ordine.setDataOrdine((req.getDataOrdine() == null || req.getDataOrdine().isEmpty())
	            ? new Date() 
	            : convertStringToDate(req.getDataOrdine()));

	    Optional<Carrello> carrelloOpt = Optional.ofNullable(req.getCarrelloId())
	            .flatMap(carR::findById);

	    carrelloOpt.ifPresent(ordine::setCarrello);

	    Optional<Utente> utenteOpt = Optional.ofNullable(req.getUtenteId())
	            .flatMap(utR::findById);

	    utenteOpt.ifPresent(ordine::setUtente);

	    if (carrelloOpt.isEmpty()) {
	        throw new Exception("Carrello non trovato");
	    }

	    Carrello carrello = carrelloOpt.get();

	    List<OrdineProdotto> prodottiOrdine = new ArrayList<>();
	    
	    for (CarrelloProdotto cp : carrello.getCarrelloProdotti()) {
	        Prodotto prodotto = cp.getProdotto();
	        
	        // Verifica disponibilità
	        if (prodotto.getQuantitaDisponibile() < cp.getQuantita()) {
	            throw new Exception("Quantità insufficiente per il prodotto: " + prodotto.getNome());
	        }

	        // Aggiorna quantità disponibile del prodotto
	        prodotto.setQuantitaDisponibile(prodotto.getQuantitaDisponibile() - cp.getQuantita());

	        // Creazione dell'oggetto OrdineProdotto
	        OrdineProdotto op = new OrdineProdotto();
	        op.setOrdine(ordine);
	        op.setProdotto(prodotto);
	        op.setQuantita(cp.getQuantita());
	        op.setPrezzo(prodotto.getPrezzo() * cp.getQuantita());

	        prodottiOrdine.add(op);
	    }

	    ordine.setOrdineProdotti(prodottiOrdine);
	    ordine.setQuantitaTotale(carrello.getQuantita());
	    ordine.setPrezzoTotale(carrello.getPrezzo());

	    orR.save(ordine);

	    // Salva le modifiche ai prodotti per aggiornare le quantità disponibili
	    prodottiOrdine.forEach(op ->prodottoR.save(op.getProdotto()));

	    // Elimina il carrello dopo l'ordine
	    carS.eliminaCarrello(carrello.getId());
	}



	@Override
	public List<OrdineDTO> listOrdiniConUtente() {
	    List<Ordine> ordini = orR.findAll(); // Recupera tutti gli ordini

	    return ordini.stream().map(ordine -> {
	        // Recupera l'utente associato all'ordine
	        Utente utente = ordine.getUtente();
	        return new OrdineDTO(
	            ordine.getId(),
	            ordine.getIndirizzoDiSpedizione(),
	            ordine.getCap(),
	            ordine.getCitta(),
	            ordine.getDataOrdine(),
	            utente != null ? utente.getNome() + " " + utente.getCognome() : "Utente non trovato"
	        );
	    }).collect(Collectors.toList());
	}
	
	@Override
	public List<OrdineDTO> listByUtente(Integer idUtente) {
	    // Recupera i carrelli dell'utente
	    List<Carrello> carrelli = carR.findByUtenteId(idUtente);

	    if (carrelli.isEmpty()) {
	        return Collections.emptyList(); // Se non ci sono carrelli, ritorna una lista vuota
	    }

	    // Recupera tutti gli ordini associati ai carrelli dell'utente
	    List<Ordine> ordini = new ArrayList<>();
	    for (Carrello carrello : carrelli) {
	        ordini.addAll(orR.findByCarrelloId(carrello.getId())); // Aggiungi gli ordini associati al carrello
	    }

	    // Restituisci gli ordini mappati in OrdineDTO
	    return ordini.stream().map(o -> new OrdineDTO(
	            o.getId(),
	            o.getIndirizzoDiSpedizione(),
	            o.getCap(),
	            o.getCitta(),
	            o.getDataOrdine(),
	            new CarrelloDTO(
	                    o.getCarrello().getId(),
	                    o.getCarrello().getQuantita(),
	                    o.getCarrello().getPrezzo(),
	                    buildCarrelloProdottoDTO(o.getCarrello().getCarrelloProdotti())
	            )
	    )).collect(Collectors.toList());
	}
	
	@Override
	public List<OrdineDTO> list() {
	    List<Ordine> ordini = orR.findAll(); // Recupera tutti gli ordini dal database

	    return ordini.stream().map(o -> new OrdineDTO(
	            o.getId(),
	            o.getIndirizzoDiSpedizione(),
	            o.getCap(),
	            o.getCitta(),
	            o.getDataOrdine(),
	            o.getUtente() != null ? o.getUtente().getId() : null, // Utente ID
	            o.getCarrello() != null ? new CarrelloDTO(
	                    o.getCarrello().getId(),
	                    o.getCarrello().getQuantita(),
	                    o.getCarrello().getPrezzo(),
	                    buildCarrelloProdottoDTO(o.getCarrello().getCarrelloProdotti())
	            ) : null // Se il carrello è null, evita NullPointerException
	    )).collect(Collectors.toList());
	}





}