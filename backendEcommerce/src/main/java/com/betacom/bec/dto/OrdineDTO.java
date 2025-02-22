package com.betacom.bec.dto;

import java.util.Date;

public class OrdineDTO {

	private Integer id;
	private String indirizzoDiSpedizione;
	private String cap;
	private String citta;
	private Date dataOrdine;
    private CarrelloDTO carrello;
    private String userName;
    
 




	public OrdineDTO(Integer id, String indirizzoDiSpedizione, String cap, String citta, Date dataOrdine,
			String userName) {
		super();
		this.id = id;
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
		this.cap = cap;
		this.citta = citta;
		this.dataOrdine = dataOrdine;
		this.userName = userName;
	}





	public OrdineDTO(Integer id, String indirizzoDiSpedizione, String cap, String citta, Date dataOrdine,
			CarrelloDTO carrello) {
		super();
		this.id = id;
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
		this.cap = cap;
		this.citta = citta;
		this.dataOrdine = dataOrdine;
		this.carrello = carrello;
	}
	
	
	


	public OrdineDTO(Integer id, String indirizzoDiSpedizione, String cap, String citta, Date dataOrdine) {
		super();
		this.id = id;
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
		this.cap = cap;
		this.citta = citta;
		this.dataOrdine = dataOrdine;
	}




	public OrdineDTO(Integer id, String indirizzoDiSpedizione, Date dataOrdine) {
		super();
		this.id = id;
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
		this.dataOrdine = dataOrdine;
	}













	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getIndirizzoDiSpedizione() {
		return indirizzoDiSpedizione;
	}

	public void setIndirizzoDiSpedizione(String indirizzoDiSpedizione) {
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public Date getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public CarrelloDTO getCarrello() {
		return carrello;
	}

	public void setCarrello(CarrelloDTO carrello) {
		this.carrello = carrello;
	}





	public String getUserName() {
		return userName;
	}





	public void setUserName(String userName) {
		this.userName = userName;
	}


}