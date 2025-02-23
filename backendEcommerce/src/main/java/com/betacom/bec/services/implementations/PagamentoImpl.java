package com.betacom.bec.services.implementations;

import static com.betacom.bec.utils.Utilities.convertStringToDateCarta;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.bec.models.Pagamento;
import com.betacom.bec.models.Utente;
import com.betacom.bec.repositories.PagamentoRepository;
import com.betacom.bec.repositories.UtenteRepository;
import com.betacom.bec.request.PagamentoReq;
import com.betacom.bec.services.interfaces.MessaggioServices;
import com.betacom.bec.services.interfaces.PagamentoServices;

@Service
public class PagamentoImpl implements PagamentoServices {
	
	@Autowired
	Logger log;
	
	@Autowired
	PagamentoRepository pagamentoR;
	
	@Autowired
	UtenteRepository utenteRepository;

	@Autowired
	private MessaggioServices msgS;
	
	// Metodo che crea il pagamento e lo associa all'utente
	
	@Override
	public void create(PagamentoReq req) throws Exception {


	    if (req.getMetodoDiPagamento() == null)
	        throw new Exception(msgS.getMessaggio("no-metodopagamento"));
	    if (req.getNumeroCarta() == null)
	        throw new Exception(msgS.getMessaggio("no-numerocarta"));
	    if (!isNumeroCartaValido(req.getNumeroCarta()))
	        throw new Exception(msgS.getMessaggio("numero-carta-non-valido"));
	    if (!isDataScadenzaValida(req.getDataScadenza()))
	        throw new Exception(msgS.getMessaggio("data-scadenza-non-valida"));
	    if (req.getCvv() == null)
	        throw new Exception(msgS.getMessaggio("no-cvv"));
	    if (req.getUserId() == null)
	        throw new Exception(msgS.getMessaggio("no-userid"));

	    // Recupera l'utente dal database
	    Optional<Utente> utenteOpt = utenteRepository.findById(req.getUserId());
	    if (utenteOpt.isEmpty()) {
	        throw new Exception(msgS.getMessaggio("utente-non-trovato"));
	    }

	    Pagamento pg = new Pagamento();
	    pg.setMetodoDiPagamento(req.getMetodoDiPagamento());
	    pg.setNumeroCarta(req.getNumeroCarta());
	    pg.setDataScadenza(convertStringToDateCarta(req.getDataScadenza()));
	    pg.setCvv(req.getCvv());
	    pg.setUtente(utenteOpt.get());  // Associa il pagamento all'utente trovato

	    pagamentoR.save(pg);
	}


	// Metodo che gestisce la data di scadenza, formato mm/yy
	
	public boolean isDataScadenzaValida(String dataScadenza) throws DateTimeParseException {
	    if (dataScadenza == null) return false;

	    // Verifica che la data rispetti il formato MM/YY
	    if (!dataScadenza.matches("^(0[1-9]|1[0-2])/[0-9]{2}$")) {
	        return false;
	    }

	    try {
	        // Converte la data in YearMonth per validare ulteriormente
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
	        YearMonth data = YearMonth.parse(dataScadenza, formatter);
	        
	        // La data di scadenza deve essere futura o il mese corrente
	        return !data.isBefore(YearMonth.now());
	    } catch (DateTimeParseException e) {
	        return false;
	    }
	}


	// Metodo che gestisce il numero della carta > minimo 13 a max 19 numeri

	public boolean isNumeroCartaValido(String numeroCarta) {
	    if (numeroCarta == null || !numeroCarta.matches("\\d{13,19}")) {
	        return false; 
	    }
	    return true;
	}

	
	// Metodo che recupera i pagamenti salvati per un utente
	
	@Override
    public List<Pagamento> getPagamentiByUserId(Integer userId) {
        return pagamentoR.findByUtente_Id(userId);  
    }


	// Rimuovi pagamento

	@Override
	public void removePagamento(PagamentoReq req) throws Exception {
	    // Verifica che l'ID del pagamento sia fornito
	    if (req.getId() == null) {
	        throw new Exception(msgS.getMessaggio("no-pagamento-id"));
	    }

	    // Recupera il pagamento dal database
	    Optional<Pagamento> pagamentoOpt = pagamentoR.findById(req.getId());
	    if (pagamentoOpt.isEmpty()) {
	        throw new Exception(msgS.getMessaggio("pagamento-non-trovato"));
	    }

	    Pagamento pagamento = pagamentoOpt.get();

	    // Verifica che il pagamento sia associato all'utente
	    if (pagamento.getUtente() == null || !pagamento.getUtente().getId().equals(req.getUserId())) {
	        throw new Exception(msgS.getMessaggio("pagamento-non-associato-utente"));
	    }

	    // Rimuovi il pagamento
	    pagamentoR.delete(pagamento);
	    log.debug("Pagamento con ID " + req.getId() + " rimosso per l'utente con ID " + req.getUserId());
	}
	
	@Override
	public void update(PagamentoReq req) throws Exception {
        Optional<Pagamento> u = pagamentoR.findById(req.getId());
        if (u.isEmpty())
            throw new Exception("Pagamento inesistente");
        if (req.getMetodoDiPagamento() != null)
            u.get().setMetodoDiPagamento(req.getMetodoDiPagamento());
        if (req.getNumeroCarta() != null)
            u.get().setNumeroCarta(req.getNumeroCarta());
        if (req.getCvv() != null)
            u.get().setCvv(req.getCvv());
        if (req.getDataScadenza() != null)
            u.get().setDataScadenza(convertStringToDateCarta(req.getDataScadenza()));

        pagamentoR.save(u.get());

    }



}