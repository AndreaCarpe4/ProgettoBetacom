package com.betacom.fe.response;

import java.util.List;


public class ResponseList<T> extends ResponseBase{

	private List<T> dati;

	public List<T> getDati() {
		return dati;
	}

	public void setDati(List<T> dati) {
		this.dati = dati;
	}

	
}
