package com.betacom.bec.request;

public class OrdineProdottoReq {

	private Integer id;
	private Integer quantita;
    private Double prezzo;
    private Integer prodottoId;
    private Integer carrelloId;
    private Integer utenteId;
    
	public OrdineProdottoReq(Integer id, Integer quantita, Double prezzo, Integer prodottoId, Integer carrelloId,
			Integer utenteId) {
		super();
		this.id = id;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.prodottoId = prodottoId;
		this.carrelloId = carrelloId;
		this.utenteId = utenteId;
	}

	public OrdineProdottoReq() {
		super();
	}

	@Override
	public String toString() {
		return "OrdineProdottoDTO [id=" + id + ", quantita=" + quantita + ", prezzo=" + prezzo + ", prodottoId="
				+ prodottoId + ", carrelloId=" + carrelloId + ", utenteId=" + utenteId + "]";
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

	public Integer getProdottoId() {
		return prodottoId;
	}

	public void setProdottoId(Integer prodottoId) {
		this.prodottoId = prodottoId;
	}

	public Integer getCarrelloId() {
		return carrelloId;
	}

	public void setCarrelloId(Integer carrelloId) {
		this.carrelloId = carrelloId;
	}

	public Integer getUtenteId() {
		return utenteId;
	}

	public void setUtenteId(Integer utenteId) {
		this.utenteId = utenteId;
	}
    
}
