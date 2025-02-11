package com.betacom.bec.models;

import java.sql.Timestamp;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity //tutti i db e tabelle sono entity
@Table (name="recensioni")
public class Recensione {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=100,
    		nullable=false)
	private Integer valutazione;
	
	@Column(length=100,
    		nullable=false)
	private String commento;
	
	@Column(name="data_recensione",
			length=100,
    		nullable=false)
	private Timestamp dataRecensione;
	
	@ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "id_prodotto")
    private Prodotto prodotto;

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

	public Timestamp getDataRecensione() {
		return dataRecensione;
	}

	public void setDataRecensione(Timestamp dataRecensione) {
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
