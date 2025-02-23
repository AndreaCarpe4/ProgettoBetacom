package com.betacom.bec.services.implementations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.bec.dto.CarrelloDTO;
import com.betacom.bec.models.Carrello;
import com.betacom.bec.models.CarrelloProdotto;
import com.betacom.bec.models.Prodotto;
import com.betacom.bec.repositories.CarrelloProdottoRepository;
import com.betacom.bec.repositories.CarrelloRepository;
import com.betacom.bec.repositories.ProdottoRepository;
import com.betacom.bec.services.interfaces.CarrelloServices;

import static com.betacom.bec.utils.Utilities.buildCarrelloProdottoDTO;

@Service
public class CarrelloImpl implements CarrelloServices{

	@Autowired
    private CarrelloRepository carrelloRepository;
	
	@Autowired
    private ProdottoRepository prodottoRepository;
	
    
    @Autowired
    private CarrelloProdottoRepository carrelloProdottoRepository;
	
	@Autowired
	Logger log;
	
	@Override
	public Carrello aggiungiProdottoAlCarrello(Integer utenteId, Integer carrelloId, Integer prodottoId, Integer quantita) {
	    // Trova il carrello specifico per l'utente
	    Optional<Carrello> carrelloOptional = carrelloRepository.findById(carrelloId);
	    Optional<Prodotto> prodottoOptional = prodottoRepository.findById(prodottoId);

	    if (!carrelloOptional.isPresent()) {
	        throw new RuntimeException("Carrello non trovato per l'utente con ID " + utenteId);
	    }
	    if (!prodottoOptional.isPresent()) {
	        throw new RuntimeException("Prodotto con ID " + prodottoId + " non trovato.");
	    }

	    Carrello carrello = carrelloOptional.get();
	    Prodotto prodotto = prodottoOptional.get();

	    // Se il carrello non ha ancora prodotti, inizializzalo
	    if (carrello.getCarrelloProdotti() == null) {
	        carrello.setCarrelloProdotti(new ArrayList<>());
	    }

	    // Verifica se il prodotto è già presente nel carrello, altrimenti creane uno nuovo
	    Optional<CarrelloProdotto> optionalCarrelloProdotto = carrelloProdottoRepository.findByCarrelloAndProdotto(carrello, prodotto);
	    CarrelloProdotto carrelloProdotto = optionalCarrelloProdotto.orElseGet(() -> {
	        CarrelloProdotto nuovoCarrelloProdotto = new CarrelloProdotto();
	        nuovoCarrelloProdotto.setCarrello(carrello);
	        nuovoCarrelloProdotto.setProdotto(prodotto);
	        nuovoCarrelloProdotto.setQuantita(0);
	        carrello.getCarrelloProdotti().add(nuovoCarrelloProdotto);
	        return nuovoCarrelloProdotto;
	    });

	    // Aggiungi la quantità richiesta
	    carrelloProdotto.setQuantita(carrelloProdotto.getQuantita() + quantita);
	    carrelloProdottoRepository.save(carrelloProdotto);

	    // Aggiorna i totali del carrello
	    carrello.aggiornaTotali();
	    return carrelloRepository.save(carrello);
	}

    

	@Override
	public Carrello rimuoviProdotto(Integer utenteId, Integer carrelloId, Integer prodottoId, Integer quantitaDaRimuovere) {
	    // Trova il carrello specifico per l'utente
	    Optional<Carrello> carrelloOptional = carrelloRepository.findById(carrelloId);
	    Optional<Prodotto> prodottoOptional = prodottoRepository.findById(prodottoId);

	    if (!carrelloOptional.isPresent()) {
	        throw new RuntimeException("Carrello non trovato per l'utente " + utenteId);
	    }
	    if (!prodottoOptional.isPresent()) {
	        throw new RuntimeException("Prodotto con ID " + prodottoId + " non trovato.");
	    }

	    Carrello carrello = carrelloOptional.get();
	    Prodotto prodotto = prodottoOptional.get();

	    // Trova il prodotto nel carrello
	    Optional<CarrelloProdotto> carrelloProdottoOptional = carrelloProdottoRepository.findByCarrelloAndProdotto(carrello, prodotto);

	    if (!carrelloProdottoOptional.isPresent()) {
	        throw new RuntimeException("Prodotto non presente nel carrello.");
	    }

	    CarrelloProdotto carrelloProdotto = carrelloProdottoOptional.get();

	    // RIDUCE LA QUANTITÀ DEL PRODOTTO
	    int nuovaQuantita = carrelloProdotto.getQuantita() - quantitaDaRimuovere;

	    if (nuovaQuantita > 0) {
	        carrelloProdotto.setQuantita(nuovaQuantita);
	        carrelloProdottoRepository.save(carrelloProdotto);
	    } else {
	        // SE LA QUANTITÀ SCENDE A 0, RIMUOVE IL PRODOTTO DAL CARRELLO
	        carrello.getCarrelloProdotti().remove(carrelloProdotto);  // 🔥 RIMUOVE IL PRODOTTO DALLA LISTA DEL CARRELLO
	        carrelloProdottoRepository.delete(carrelloProdotto);
	        carrelloProdottoRepository.flush(); // 🔥 FORZA L'ELIMINAZIONE DAL DB
	    }

	    // AGGIORNA AUTOMATICAMENTE I TOTALI DEL CARRELLO USANDO LE QUERY
	    Integer nuovaQuantitaTotale = carrelloRepository.getQuantitaTotale(carrello.getId());
	    Double nuovoPrezzoTotale = carrelloRepository.getPrezzoTotale(carrello.getId());

	    carrello.setQuantita(nuovaQuantitaTotale != null ? nuovaQuantitaTotale : 0);
	    carrello.setPrezzo(nuovoPrezzoTotale != null ? nuovoPrezzoTotale : 0.0);

	    return carrelloRepository.save(carrello);
	}




	@Override
	public List<CarrelloDTO> ottieniCarrello(Integer utenteId) {
	    // Filtra i carrelli in base all'utenteId
	    List<Carrello> lU = carrelloRepository.findByUtenteId(utenteId);  // Usa un metodo di ricerca per utenteId
	    return lU.stream()
	            .map(u -> new CarrelloDTO(u.getId(),
	                    u.getQuantita(),
	                    u.getPrezzo(),
	                    buildCarrelloProdottoDTO(u.getCarrelloProdotti())))
	            .collect(Collectors.toList());
	}

 
	
}