package com.betacom.bec.dto;

import java.util.List;

import com.betacom.bec.models.CarrelloProdotto;
import com.betacom.bec.models.Prodotto;
import com.betacom.bec.models.Utente;

public class CarrelloDTO {

	private Integer id;
    private Integer quantita;
    private Double prezzo;
    private Integer utente;
    private List<CarrelloProdottoDTO> carrelloProdottiDTO;
    

	public CarrelloDTO(Integer id, Integer quantita, Double prezzo,
			List<CarrelloProdottoDTO> carrelloProdottiDTO) {
		super();
		this.id = id;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.carrelloProdottiDTO = carrelloProdottiDTO;
	}






	public CarrelloDTO(Integer id, Integer quantita, Double prezzo, Integer idUtente,
			List<CarrelloProdottoDTO> carrelloProdottiDTO) {
		this.id = id;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.utente = idUtente;
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





	public Integer getUtente() {
		return utente;
	}






	public void setUtente(Integer utente) {
		this.utente = utente;
	}






	public List<CarrelloProdottoDTO> getCarrelloProdottiDTO() {
		return carrelloProdottiDTO;
	}






	public void setCarrelloProdottiDTO(List<CarrelloProdottoDTO> carrelloProdottiDTO) {
		this.carrelloProdottiDTO = carrelloProdottiDTO;
	}






	public List<CarrelloProdottoDTO> getCarrelloProdotti() {
		return carrelloProdottiDTO;
	}



	public void setCarrelloProdotti(List<CarrelloProdottoDTO> carrelloProdotti) {
		this.carrelloProdottiDTO = carrelloProdotti;
	}



 

}