package com.betacom.fe.request;


public class CarrelloReq {

	private Integer id;
    private Integer idProdotto;
    private Integer quantita;
    private Double prezzo;
    
	public CarrelloReq(Integer id, Integer idProdotto, Integer quantita, Double prezzo) {
		super();
		this.id = id;
		this.idProdotto = idProdotto;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}

	public CarrelloReq() {
		super();
	}

	@Override
	public String toString() {
		return "CarrelloReq [id=" + id  + ", idProdotto="
				+ idProdotto + ", quantita=" + quantita + ", prezzo=" + prezzo + "]";
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
    
    
	
	
}