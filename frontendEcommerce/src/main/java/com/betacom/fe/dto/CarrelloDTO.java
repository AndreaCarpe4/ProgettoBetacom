package com.betacom.fe.dto;

import java.util.List;


public class CarrelloDTO {

	private Integer id;
    private Integer quantita;
    private Double prezzo;
    //private UtenteDTO utente;
    private List<CarrelloProdottoDTO> carrelloProdottiDTO;
    


	public CarrelloDTO(Integer id, Integer quantita, Double prezzo, UtenteDTO utente,
			List<CarrelloProdottoDTO> carrelloProdottiDTO) {
		super();
		this.id = id;
		this.quantita = quantita;
		this.prezzo = prezzo;
		//this.utente = utente;
		this.carrelloProdottiDTO = carrelloProdottiDTO;
	}



	public CarrelloDTO(Integer id, Integer quantita, Double prezzo,
			List<CarrelloProdottoDTO> carrelloProdottiDTO) {
		super();
		this.id = id;
		this.quantita = quantita;
		this.prezzo = prezzo;

		this.carrelloProdottiDTO = carrelloProdottiDTO;
	}






	@Override
	public String toString() {
		return "CarrelloDTO [id=" + id + ", quantita=" + quantita + ", prezzo=" + prezzo + ", carrelloProdottiDTO="
				+ carrelloProdottiDTO + "]";
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

//	public UtenteDTO getUtente() {
//		return utente;
//	}
//
//	public void setUtente(UtenteDTO utente) {
//		this.utente = utente;
//	}



	public List<CarrelloProdottoDTO> getCarrelloProdotti() {
		return carrelloProdottiDTO;
	}



	public void setCarrelloProdotti(List<CarrelloProdottoDTO> carrelloProdotti) {
		this.carrelloProdottiDTO = carrelloProdotti;
	}



 

}