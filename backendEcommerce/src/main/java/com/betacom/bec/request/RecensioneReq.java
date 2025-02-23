package com.betacom.bec.request;

import com.betacom.bec.models.Prodotto;
import com.betacom.bec.models.Utente;

public class RecensioneReq {

	private Integer id;
    private Integer valutazione;
    private String commento;
    private String dataRecensione;
    private Utente utente;
    private Prodotto prodotto;

	public RecensioneReq(Integer id, Integer valutazione, String commento, String dataRecensione, Utente utente,
			Prodotto prodotto) {
		super();
		this.id = id;
		this.valutazione = valutazione;
		this.commento = commento;
		this.dataRecensione = dataRecensione;
		this.utente = utente;
		this.prodotto = prodotto;
	}

	public RecensioneReq() {
		super();
	}

	@Override
	public String toString() {
		return "RecensioneReq [id=" + id + ", valutazione=" + valutazione + ", commento=" + commento
				+ ", dataRecensione=" + dataRecensione + ", utente=" + utente + ", prodotto=" + prodotto + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getValutazione() {
		return valutazione;
	}

	public void setValutazione(Integer valutazione) {
		this.valutazione = valutazione;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public String getDataRecensione() {
		return dataRecensione;
	}

	public void setDataRecensione(String dataRecensione) {
		this.dataRecensione = dataRecensione;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
   
	
    
}