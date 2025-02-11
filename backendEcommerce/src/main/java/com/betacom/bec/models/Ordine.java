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
@Table (name="ordini")
public class Ordine {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="prezzo_totale",
			length=100,
    		nullable=false)
	private Double prezzoTotale;
	
	@Column(name="indirizzo_spedizione",
			length=100,
    		nullable=false)
	private String indirizzoDiSpedizione;
	
	@Column(length=100,
    		nullable=false)
	private Integer cap;
	
	@Column(name="data_ordine",
			length=100,
    		nullable=false)
	private Timestamp dataOrdine;
	
	@Column(length=100,
    		nullable=false)
	private Integer quantità;
	
	@Column(length=100,
    		nullable=false)
	private String stato;
	
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

	public Double getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(Double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	public String getIndirizzoDiSpedizione() {
		return indirizzoDiSpedizione;
	}

	public void setIndirizzoDiSpedizione(String indirizzoDiSpedizione) {
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
	}

	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public Timestamp getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(Timestamp dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public Integer getQuantità() {
		return quantità;
	}

	public void setQuantità(Integer quantità) {
		this.quantità = quantità;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
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
