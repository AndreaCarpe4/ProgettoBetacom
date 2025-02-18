package com.betacom.fe.request;



public class RecensioneReq {

	private Integer id;
    private Integer valutazione;
    private String commento;
    private String dataRecensione;


	public RecensioneReq(Integer id, Integer valutazione, String commento, String dataRecensione
			) {
		super();
		this.id = id;
		this.valutazione = valutazione;
		this.commento = commento;
		this.dataRecensione = dataRecensione;
		
	}

	public RecensioneReq() {
		super();
	}

	@Override
	public String toString() {
		return "RecensioneReq [id=" + id + ", valutazione=" + valutazione + ", commento=" + commento
				+ ", dataRecensione=" + dataRecensione + "]";
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


   
	
    
}