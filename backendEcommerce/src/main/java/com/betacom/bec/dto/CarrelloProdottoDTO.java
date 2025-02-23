package com.betacom.bec.dto;

import com.betacom.bec.models.Carrello;
import com.betacom.bec.models.Prodotto;

public class CarrelloProdottoDTO {

	   private Integer id;
	   private Carrello carrello;
	   private Prodotto prodotto;
	   private Integer quantita;
	   
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Carrello getCarrello() {
		return carrello;
	}
	public void setCarrello(Carrello carrello) {
		this.carrello = carrello;
	}
	public Prodotto getProdotto() {
		return prodotto;
	}
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	@Override
	public String toString() {
		return "CarrelloProdottoDTO [id=" + id + ", carrello=" + carrello + ", prodotto=" + prodotto + ", quantita="
				+ quantita + "]";
	}
	public CarrelloProdottoDTO(Integer id, Prodotto prodotto,Integer quantita) {
		super();
		this.id = id;
		this.prodotto = prodotto;
		this.quantita = quantita;
	}
	public CarrelloProdottoDTO(Integer id, Prodotto prodotto) {
		this.id = id;
		this.prodotto = prodotto;
	}

	   
	   

}