package com.betacom.bec.dto;

import java.util.List;

import com.betacom.bec.models.CarrelloProdotto;
import com.betacom.bec.models.Prodotto;

public class CarrelloDTO {

	private Integer id;
    private Integer idProdotto;
    private Integer quantita;
    private Double prezzo;
    private UtenteDTO utente;
    private List<CarrelloProdotto> carrelloProdotti;
    private Prodotto prodotto;
    
	public CarrelloDTO(Integer id, Integer idProdotto, Integer quantita, Double prezzo, UtenteDTO utente,
			List<CarrelloProdotto> carrelloProdotti, Prodotto prodotto) {
		super();
		this.id = id;
		this.idProdotto = idProdotto;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.utente = utente;
		this.carrelloProdotti = carrelloProdotti;
		this.prodotto = prodotto;
	}

	public CarrelloDTO() {
		super();
	}

	@Override
	public String toString() {
		return "CarrelloDTO [id=" + id + ", idProdotto=" + idProdotto + ", quantita=" + quantita + ", prezzo=" + prezzo
				+ ", utente=" + utente + ", carrelloProdotti=" + carrelloProdotti + ", prodotto=" + prodotto + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public UtenteDTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

	public List<CarrelloProdotto> getCarrelloProdotti() {
		return carrelloProdotti;
	}

	public void setCarrelloProdotti(List<CarrelloProdotto> carrelloProdotti) {
		this.carrelloProdotti = carrelloProdotti;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
    
    
	
    
	
    
    

}
