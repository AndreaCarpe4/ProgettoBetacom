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
@Table (name="pagamenti")
public class Pagamento {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="metodo_pagamento",
			length=100,
    		nullable=false)
	private String metodoDiPagamento;
	
	@Column(name="stato_pagamento",
			length=100,
    		nullable=false)
	private String statoPagamento;
	
	@Column(length=100,
    		nullable=false)
	private Double importo;
	
	@Column(name="data_pagamento",
			length=100,
    		nullable=false)
	private Timestamp dataPagamento;
	
	@ManyToOne
    @JoinColumn(name = "id_ordine")
    private Ordine ordine;

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

	public String getStatoPagamento() {
		return statoPagamento;
	}

	public void setStatoPagamento(String statoPagamento) {
		this.statoPagamento = statoPagamento;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public Timestamp getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Timestamp dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	
	


}
