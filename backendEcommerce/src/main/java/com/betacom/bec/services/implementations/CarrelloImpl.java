package com.betacom.bec.services.implementations;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.bec.models.Carrello;
import com.betacom.bec.models.CarrelloProdotto;
import com.betacom.bec.models.Prodotto;
import com.betacom.bec.repositories.CarrelloProdottoRepository;
import com.betacom.bec.repositories.CarrelloRepository;
import com.betacom.bec.repositories.ProdottoRepository;
import com.betacom.bec.repositories.UtenteRepository;
import com.betacom.bec.services.interfaces.CarrelloServices;

@Service
public class CarrelloImpl implements CarrelloServices{

	@Autowired
    private CarrelloRepository carrelloRepository;
	
	@Autowired
    private ProdottoRepository prodottoRepository;
	
    @Autowired
    private UtenteRepository utenteRepository;
    
    @Autowired
    private CarrelloProdottoRepository carrelloProdottoRepository;
	
	@Autowired
	Logger log;
	
	
	// Metodo per aggiungere un prodotto al carrello e aggiornare il prezzo totale
    public Carrello aggiungiProdottoAlCarrello(Integer carrelloId, Integer prodottoId, Integer quantita) {
        Optional<Carrello> carrelloOptional = carrelloRepository.findById(carrelloId);
        Optional<Prodotto> prodottoOptional = prodottoRepository.findById(prodottoId);

        if (carrelloOptional.isPresent() && prodottoOptional.isPresent()) {
            Carrello carrello = carrelloOptional.get();
            Prodotto prodotto = prodottoOptional.get();

            // Verifica se il prodotto è già nel carrello
            CarrelloProdotto carrelloProdotto = carrelloProdottoRepository.findByCarrelloAndProdotto(carrello, prodotto);
            if (carrelloProdotto != null) {
                // Se il prodotto è già nel carrello, aggiorna la quantità
                carrelloProdotto.setQuantita(carrelloProdotto.getQuantita() + quantita);
            } else {
                // Se il prodotto non è nel carrello, lo aggiunge
                carrelloProdotto = new CarrelloProdotto();
                carrelloProdotto.setCarrello(carrello);
                carrelloProdotto.setProdotto(prodotto);
                carrelloProdotto.setQuantita(quantita);
            }

            // Salva le modifiche
            carrelloProdottoRepository.save(carrelloProdotto);

            // Aggiorna il prezzo totale del carrello
            aggiornaPrezzoTotaleCarrello(carrello);

            // Ritorna il carrello aggiornato
            return carrelloRepository.save(carrello);
        } else {
            throw new RuntimeException("Carrello o prodotto non trovato");
        }
    }

 // Metodo per aggiornare il prezzo totale del carrello
    private void aggiornaPrezzoTotaleCarrello(Carrello carrello) {
        double totale = 0;

        for (CarrelloProdotto cp : carrello.getCarrelloProdotti()) {
            double prezzoProdotto = cp.getProdotto().getPrezzo(); // Assicurati che Prodotto abbia il campo `prezzo`
            double prezzoTotaleProdotto = prezzoProdotto * cp.getQuantita();
            totale += prezzoTotaleProdotto;
        }

        carrello.setPrezzo(totale);
        carrelloRepository.save(carrello);
    }
	
	

	@Override
    public void rimuoviProdotto(int carrelloId) {
		carrelloRepository.deleteById(carrelloId);
    }

//	@Override
//	public Carrello aggiornaQuantita(int carrelloId, int quantita) {
//	    // Trova l'elemento nel carrello
//	    Carrello carrello = carrelloRepository.findById(carrelloId)
//	            .orElseThrow(() -> new RuntimeException("Elemento nel carrello non trovato"));
//
//	    // Trova il prodotto associato al carrello
//	    Prodotto prodotto = carrello.getProdotti();
//
//	    // Verifica che ci sia sufficiente quantità del prodotto
//	    if (prodotto.getQuantitaDisponibile() < quantita) {
//	        throw new RuntimeException("Quantità richiesta non disponibile");
//	    }
//
//	    // Aggiorna la quantità del prodotto nel carrello
//	    carrello.setQuantita(quantita);
//	    carR.save(carrello); // Salva l'aggiornamento del carrello
//
//	    // Aggiorna la quantità del prodotto nel database
//	    prodotto.setQuantitaDisponibile(prodotto.getQuantitaDisponibile() - quantita);
//	    prodottoRepository.save(prodotto); // Salva l'aggiornamento del prodotto
//
//	    return carrello;
//	}


    @Override
    public List<Carrello> ottieniCarrello(int utenteId) {
        return carrelloRepository.findByUtenteId(utenteId);
    }

	@Override
	public Carrello aggiungiProdotto(int utenteId, int prodottoId, int quantita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrello aggiornaQuantita(int carrelloId, int quantita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calcolaTotaleCarrello(int utenteId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Carrello aggiornaPrezziCarrello(int utenteId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
