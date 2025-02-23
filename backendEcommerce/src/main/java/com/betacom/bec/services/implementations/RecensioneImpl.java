package com.betacom.bec.services.implementations;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.bec.dto.ProdottoDTO;
import com.betacom.bec.dto.RecensioneDTO;
import com.betacom.bec.dto.UtenteDTO;
import com.betacom.bec.models.Recensione;
import com.betacom.bec.repositories.OrdineRepository;
import com.betacom.bec.repositories.RecensioneRepository;
import com.betacom.bec.request.RecensioneReq;
import com.betacom.bec.services.interfaces.MessaggioServices;
import com.betacom.bec.services.interfaces.RecensioneServices;

import static com.betacom.bec.utils.Utilities.convertStringToDate;

@Service
public class RecensioneImpl implements RecensioneServices {

    @Autowired
    RecensioneRepository recR;

    @Autowired
    OrdineRepository ordineR;
    
    @Autowired
    private MessaggioServices msgS;

    @Autowired
    Logger log;
    

    @Override
    public void create(RecensioneReq req) throws Exception {

        System.out.println("Create : " + req);

        if (req.getValutazione() == null)
            throw new Exception(msgS.getMessaggio("no-valutazione"));
        if (req.getCommento() == null)
            throw new Exception(msgS.getMessaggio("no-commento"));
        if (req.getUtente() == null)
            throw new Exception(msgS.getMessaggio("no-utente"));
        if (req.getProdotto() == null)
            throw new Exception(msgS.getMessaggio("no-prodotto"));

        // Verifica se l'utente ha acquistato il prodotto
        boolean haAcquistato = ordineR.existsByUtenteAndProdotto(req.getUtente(), req.getProdotto());
        if (!haAcquistato) {
            throw new Exception(msgS.getMessaggio("no-acquisto"));
        }

        // Verifica se l'utente ha già recensito il prodotto
        boolean haGiaRecensito = recR.existsByUtenteAndProdotto(req.getUtente(), req.getProdotto());
        if (haGiaRecensito) {
            throw new Exception(msgS.getMessaggio("recensione-gia-presente"));
        }

        Recensione rec = new Recensione();
        rec.setValutazione(req.getValutazione());
        rec.setCommento(req.getCommento());

        // Imposta la data di recensione (se non presente, usa la data corrente)
        if (req.getDataRecensione() == null || req.getDataRecensione().isEmpty()) {
            rec.setDataRecensione(new Date());
        } else {
            rec.setDataRecensione(convertStringToDate(req.getDataRecensione()));
        }

        rec.setUtente(req.getUtente());
        rec.setProdotto(req.getProdotto());

        // Salva la recensione
        recR.save(rec);
    }


    

    @Override
    public void update(RecensioneReq req) throws Exception {
        log.debug("Update: " + req);

        // Controllo se già esiste una recensione con lo stesso ID
        Optional<Recensione> optRecensione = recR.findById(req.getId());
        if (optRecensione.isEmpty()) {
            throw new Exception(msgS.getMessaggio("no-recensione"));
        }

        Recensione r = optRecensione.get();
        r.setValutazione(req.getValutazione());
        r.setCommento(req.getCommento());

        recR.save(r);
    }

    @Override
    public List<RecensioneDTO> listAllRecensioni() throws Exception {
        List<Recensione> recensioni = recR.findAll();
        return recensioni.stream().map(u -> new RecensioneDTO(
                u.getId(),
                u.getValutazione(),
                u.getCommento(),
                u.getDataRecensione(),
                (u.getUtente() == null) ? null : new UtenteDTO(
                        u.getUtente().getId(),
                        u.getUtente().getNome(),
                        u.getUtente().getCognome()
                ),
                (u.getProdotto() == null) ? null : new ProdottoDTO(
                        u.getProdotto().getMarca(),
                        u.getProdotto().getNome(),
                        u.getProdotto().getCategoria(),
                        u.getProdotto().getDescrizione(),
                        u.getProdotto().getPrezzo(),
                        u.getProdotto().getUrlImg(),
                        u.getProdotto().getColore()
                )
        )).collect(Collectors.toList());
    }

    @Override
    public void removeRecensione(RecensioneReq req) throws Exception {
        Optional<Recensione> rec = recR.findById(req.getId());
        if (rec.isEmpty()) {
            throw new Exception(msgS.getMessaggio("no-recensione"));
        }

        recR.delete(rec.get());
    }

    @Override
    public List<RecensioneDTO> listByProdotto(Integer idProdotto) {
        List<Recensione> recensioni = recR.findByProdottoId(idProdotto);
        return recensioni.stream().map(u -> new RecensioneDTO(
                u.getId(),
                u.getValutazione(),
                u.getCommento(),
                u.getDataRecensione(),
                (u.getUtente() == null) ? null : new UtenteDTO(
                        u.getUtente().getId(),
                        u.getUtente().getNome(),
                        u.getUtente().getCognome()
                ),
                (u.getProdotto() == null) ? null : new ProdottoDTO(
                        u.getProdotto().getMarca(),
                        u.getProdotto().getNome(),
                        u.getProdotto().getCategoria(),
                        u.getProdotto().getDescrizione(),
                        u.getProdotto().getPrezzo(),
                        u.getProdotto().getUrlImg(),
                        u.getProdotto().getColore()
                )
        )).collect(Collectors.toList());
    }
}