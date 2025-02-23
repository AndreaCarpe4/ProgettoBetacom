package com.betacom.bec.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


import com.betacom.bec.dto.CarrelloProdottoDTO;

import com.betacom.bec.models.CarrelloProdotto;



public class Utilities {

	private final static String PATTERN_DATE="dd/MM/yyyy";
	private final static String PATTERN_DATE_CARTA="MM/yyyy";
	
	public static Date convertStringToDate(String dataString) throws ParseException {
		
		SimpleDateFormat formatter= new SimpleDateFormat(PATTERN_DATE, Locale.ITALY);
		return formatter.parse(dataString);
	}
	
	public static Date convertStringToDateCarta(String dataString) throws ParseException {
		
		SimpleDateFormat formatter= new SimpleDateFormat(PATTERN_DATE_CARTA, Locale.ITALY);
		return formatter.parse(dataString);
	}
	
     public static String convertDateToString(Date data){
		DateFormat formatter= new SimpleDateFormat(PATTERN_DATE, Locale.ITALY);
		return formatter.format(data);
	}
	
     
     public static List<CarrelloProdottoDTO> buildCarrelloProdottoDTO(List<CarrelloProdotto> a) {
    	    return a.stream()
    	            .map(r -> new CarrelloProdottoDTO(
    	                    r.getId(),
    	                    r.getProdotto(), 
    	                    r.getQuantita()  // Assicurati che quantita venga presa dal CarrelloProdotto
    	            ))
    	            .collect(Collectors.toList());
    	}


	
}