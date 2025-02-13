package com.betacom.bec.models;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="pagamenti")
public class Pagamento {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="metodo_pagamento",
			length=100,
    		nullable=false)
	private String metodoDiPagamento; // scegliere tra mastercard ecc...
	
	@Column(name="numero_carta",
			length=19,
    		nullable=false)
	private String numeroCarta;
	
	@Column(length=100,
    		nullable=false)
	private Double importo;
	
	@Column(name="data_scadenza", // da cambiare in mese/anno -> 00/00
			length=100,
    		nullable=false)
	private Date dataScadenza;
	
	@Column(name="cvv",
			length=3,
    		nullable=false)
	private Integer cvv;
	
	@ManyToOne
	@JoinColumn(name = "id_ordine", nullable = true)
	private Ordine ordine;

	@ManyToOne
    @JoinColumn(name = "id_utente") 
    private Utente utente;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMetodoDiPagamento() {
		return metodoDiPagamento;
	}

	public void setMetodoDiPagamento(String metodoDiPagamento) {
		this.metodoDiPagamento = metodoDiPagamento;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	
	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}


}
