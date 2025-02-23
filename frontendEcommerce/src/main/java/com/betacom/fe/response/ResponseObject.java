package com.betacom.fe.response;

public class ResponseObject<T> extends ResponseBase{

	private T dati;

	public T getDati() {
		return dati;
	}

	public void setDati(T dati) {
		this.dati = dati;
	}

	public boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}