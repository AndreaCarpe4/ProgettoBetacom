package com.betacom.bec.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity //tutti i db e tabelle sono entity
@Table (name="carrello")
public class Carrello {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=100,
    		nullable=false)
	private Integer quantita;
	
	@Column(length=100,
    		nullable=false)
	private Double prezzo;
	
	@OneToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;
	
	@OneToMany(mappedBy = "carrello", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<CarrelloProdotto> carrelloProdotti;

	@ManyToOne
	@JoinColumn(name = "id_prodotto")
	private Prodotto prodotto;

	

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public List<CarrelloProdotto> getCarrelloProdotti() {
		return carrelloProdotti;
	}

	public void setCarrelloProdotti(List<CarrelloProdotto> carrelloProdotti) {
		this.carrelloProdotti = carrelloProdotti;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	


	
	

	
}
