package com.betacom.fe.dto;



public class CarrelloProdottoDTO {

	   private Integer id;
	   private CarrelloDTO carrello;
	   private ProdottoDTO prodotto;
	   private Integer quantita;
	
	   
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CarrelloDTO getCarrello() {
		return carrello;
	}
	public void setCarrello(CarrelloDTO carrello) {
		this.carrello = carrello;
	}
	public ProdottoDTO getProdotto() {
		return prodotto;
	}
	public void setProdotto(ProdottoDTO prodotto) {
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
	public CarrelloProdottoDTO(Integer id, CarrelloDTO carrello, ProdottoDTO prodotto, Integer quantita) {
		super();
		this.id = id;
		this.prodotto = prodotto;
		this.quantita = quantita;
	}
	public CarrelloProdottoDTO(Integer id, ProdottoDTO prodotto) {
		this.id = id;
		this.prodotto = prodotto;
	}
	   
	   

}