package com.betacom.bec.dto;

import java.sql.Timestamp;

public class OrdineDTO {

	private Integer id;
	private Double prezzoTotale;
	private String indirizzoDiSpedizione;
	private Integer cap;
	private Timestamp dataOrdine;
	private Integer quantità;
	private String stato;

	public OrdineDTO(Integer id, Double prezzoTotale, String indirizzoDiSpedizione, Integer cap, Timestamp dataOrdine,
			Integer quantità, String stato) {
		super();
		this.id = id;
		this.prezzoTotale = prezzoTotale;
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
		this.cap = cap;
		this.dataOrdine = dataOrdine;
		this.quantità = quantità;
		this.stato = stato;
	}

	public OrdineDTO() {
		super();
	}

	@Override
	public String toString() {
		return "OrdineDTO [id=" + id + ", prezzoTotale=" + prezzoTotale + ", indirizzoDiSpedizione="
				+ indirizzoDiSpedizione + ", cap=" + cap + ", dataOrdine=" + dataOrdine + ", quantità=" + quantità
				+ ", stato=" + stato + "]";
	}

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

}
