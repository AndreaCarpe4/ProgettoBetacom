package com.betacom.bec.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.betacom.bec.dto.CarrelloDTO;
import com.betacom.bec.dto.UtenteDTO;
import com.betacom.bec.models.Utente;
import com.betacom.bec.repositories.UtenteRepository;
import com.betacom.bec.services.interfaces.UtenteServices;
import static com.betacom.bec.utils.Utilities.buildOrdineDTO;
import static com.betacom.bec.utils.Utilities.buildRecensioneDTO;;

public class UtenteImpl implements UtenteServices{

	@Autowired
	Logger log;
	
	@Autowired
	UtenteRepository utR;
	
	@Override
    public List<UtenteDTO> listAll() {
        List<Utente> utenti = utR.findAll();

        return utenti.stream().map(u -> new UtenteDTO(
                u.getId(),
                u.getNome(),
                u.getCognome(),
                u.getEmail(),
                u.getPsw(),
                u.getRuolo().toString(), 
                (u.getCarrello()==null)? null: new CarrelloDTO(
                        u.getCarrello().getId(),
                        u.getCarrello().getDataCreazione()
                        ),
                buildOrdineDTO(u.getOrdini()),
                buildRecensioneDTO(u.getRecensioni())
        )).collect(Collectors.toList());
    }
	
	
}
