package com.betacom.bec.request;

import java.sql.Timestamp;

public class OrdineReq {

	private Integer id;
    private Double prezzoTotale;
    private String indirizzoDiSpedizione;
    private Integer cap;
    private Integer idProdotto;
    private Timestamp dataOrdine;
    private Integer quantità;
    private String stato;
    
	public OrdineReq(Integer id, Double prezzoTotale, String indirizzoDiSpedizione, Integer cap,
			Integer idProdotto, Timestamp dataOrdine, Integer quantità, String stato) {
		super();
		this.id = id;
		this.prezzoTotale = prezzoTotale;
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
		this.cap = cap;
		this.idProdotto = idProdotto;
		this.dataOrdine = dataOrdine;
		this.quantità = quantità;
		this.stato = stato;
	}

	public OrdineReq() {
		super();
	}

	@Override
	public String toString() {
		return "OrdineReq [id=" + id + ", prezzoTotale=" + prezzoTotale
				+ ", indirizzoDiSpedizione=" + indirizzoDiSpedizione + ", cap=" + cap + ", idProdotto=" + idProdotto
				+ ", dataOrdine=" + dataOrdine + ", quantità=" + quantità + ", stato=" + stato + "]";
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

	public Integer getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
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
