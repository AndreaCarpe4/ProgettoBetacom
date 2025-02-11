package com.betacom.bec.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.betacom.bec.models.MessageID;
import com.betacom.bec.models.Messaggi;
import com.betacom.bec.repositories.MessaggioRepository;
import com.betacom.bec.services.interfaces.MessaggioServices;

@Service
public class MessaggioImpl implements MessaggioServices{
	
	@Autowired
	MessaggioRepository msgR;
	
	@Value("${lang}")
	private String lang;
	
	@Override
	public String getMessaggio(String code) {
		Optional<Messaggi>msg = msgR.findById(new MessageID(lang,code));
		String res = null;
		if (msg.isEmpty())
			res = code;
		else 
			res = msg.get().getMessaggio();
		
		return res;
	}

}