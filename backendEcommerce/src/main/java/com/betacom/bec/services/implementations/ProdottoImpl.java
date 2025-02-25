package com.betacom.bec.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.betacom.bec.dto.ProdottoDTO;
import com.betacom.bec.dto.RecensioneDTO;
import com.betacom.bec.dto.UtenteDTO;
import com.betacom.bec.models.CarrelloProdotto;
import com.betacom.bec.models.Prodotto;
import com.betacom.bec.models.Utente;
import com.betacom.bec.repositories.CarrelloProdottoRepository;
import com.betacom.bec.repositories.ProdottoRepository;
import com.betacom.bec.request.ProdottoReq;
import com.betacom.bec.services.interfaces.MessaggioServices;
import com.betacom.bec.services.interfaces.ProdottoServices;

@Service
public class ProdottoImpl implements ProdottoServices {

    @Autowired
    ProdottoRepository proR;

    @Autowired
    CarrelloProdottoRepository cpR;

    @Autowired
    private MessaggioServices msgS;

    @Autowired
    Logger log;

    // Creazione prodotto che finirà nella pagina di tutti i prodotti
    @Override
    public void create(ProdottoReq req) throws Exception {

        System.out.println("Create : " + req);

        Optional<Prodotto> c = proR.findByNome(req.getNome().trim());

        if (c.isPresent())
            throw new Exception(msgS.getMessaggio("find-prodotto"));

        if (req.getMarca() == null)
            throw new Exception(msgS.getMessaggio("no-marca"));
        if (req.getNome() == null)
            throw new Exception(msgS.getMessaggio("no-nome"));
        if (req.getCategoria() == null)
            throw new Exception(msgS.getMessaggio("no-categoria"));
        if (req.getDescrizione() == null)
            throw new Exception(msgS.getMessaggio("no-desc"));
        if (req.getPrezzo() == null)
            throw new Exception(msgS.getMessaggio("no-prezzo"));
        if (req.getquantitaDisponibile() == null)
            throw new Exception(msgS.getMessaggio("no-quantita"));
        if (req.getUrlImg() == null)
            throw new Exception(msgS.getMessaggio("no-img"));
        if (req.getSize() == null)
            throw new Exception(msgS.getMessaggio("no-size"));
        if (req.getColore() == null)
            throw new Exception(msgS.getMessaggio("no-colore"));

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

        // Salva il prodotto
        proR.save(prodotto);
    }

    @Override
    public void update(ProdottoReq req) throws Exception {
        log.debug("Update: " + req);

        // Controlla se esiste già un prodotto con lo stesso nome (case-insensitive) e ID diverso
        List<Prodotto> existingProdotti = proR.findAll();
        boolean nameExists = existingProdotti.stream().anyMatch(s ->
                s.getNome().equalsIgnoreCase(req.getNome()) &&
                        !s.getId().equals(req.getId()));

        if (nameExists) {
            throw new Exception(msgS.getMessaggio("find-prodotto"));
        }

        // Cerca il prodotto esistente tramite ID
        Optional<Prodotto> optProdotto = proR.findById(req.getId());
        if (optProdotto.isEmpty()) {
            throw new Exception(msgS.getMessaggio("no-prodotto"));
        }

        Prodotto p = optProdotto.get();

        // Aggiorna tutti i campi del prodotto
        p.setMarca(req.getMarca());
        p.setNome(req.getNome());
        p.setCategoria(req.getCategoria());
        p.setDescrizione(req.getDescrizione());
        p.setPrezzo(req.getPrezzo());
        p.setQuantitaDisponibile(req.getquantitaDisponibile());
        p.setUrlImg(req.getUrlImg());
        p.setSize(req.getSize());
        p.setColore(req.getColore());

        proR.save(p);
    }

    @Override
    public List<ProdottoDTO> listByCategoria(String categoria) {
        List<Prodotto> prodotti = proR.findByCategoria(categoria);
        return prodotti.stream().map(u -> new ProdottoDTO(
                u.getId(),
                u.getNome(),
                u.getDescrizione(),
                u.getPrezzo(),
                u.getUrlImg()
        )).collect(Collectors.toList());
    }

    @Override
    public void removeProdotto(ProdottoReq req) throws Exception {

        Optional<Prodotto> pr = proR.findById(req.getId());

        if (pr.isEmpty())
            throw new Exception(msgS.getMessaggio("no-prodotto"));

        Optional<CarrelloProdotto> cp = cpR.findById(req.getId());

        if (!cp.isEmpty())
            throw new Exception("Prodotto presente nel carrello " + cp.get().getCarrello().getId());
        proR.delete(pr.get());

    }

    @Override
    public ProdottoDTO findById(Integer id) {
        Optional<Prodotto> optionalProdotto = proR.findById(id);

        if (optionalProdotto.isEmpty()) {
            return null;
        }

        Prodotto prodotto = optionalProdotto.get();

        // Se le recensioni sono null, inizializziamo una lista vuota per evitare errori
        List<RecensioneDTO> recensioniDTO = (prodotto.getRecensioni() != null) ?
                prodotto.getRecensioni().stream()
                        .map(recensione -> new RecensioneDTO(
                                recensione.getId(),
                                recensione.getValutazione(),
                                recensione.getCommento(),
                                recensione.getDataRecensione(),
                                new UtenteDTO(recensione.getUtente().getId(), recensione.getUtente().getNome(), recensione.getUtente().getCognome()),
                                null // Evitiamo la ricorsione infinita (ProdottoDTO all'interno di RecensioneDTO)
                        ))
                        .collect(Collectors.toList())
                : new ArrayList<>();

        return new ProdottoDTO(
                prodotto.getId(),
                prodotto.getMarca(),
                prodotto.getNome(),
                prodotto.getCategoria(),
                prodotto.getDescrizione(),
                prodotto.getPrezzo(),
                prodotto.getQuantitaDisponibile(),
                prodotto.getUrlImg(),
                prodotto.getSize(),
                prodotto.getColore(),
                recensioniDTO
        );
    }

    @Override
    public List<ProdottoDTO> list() {
        List<Prodotto> prodotto = proR.findAll();

        return prodotto.stream().map(u -> new ProdottoDTO(
                u.getId(),
                u.getMarca(),
                u.getNome(),
                u.getCategoria(),
                u.getDescrizione(),
                u.getPrezzo(),
                u.getQuantitaDisponibile(),
                u.getUrlImg(),
                u.getSize(),
                u.getColore()
        )).collect(Collectors.toList());
    }
}