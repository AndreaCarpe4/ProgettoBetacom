package com.betacom.bec.dto;

import java.util.List;





public class UtenteDTO {

	 private Integer id;
	 private String nome;
	 private String cognome;
	 private String email;
	 private String password;
	 private String ruolo;
	 private CarrelloDTO carrello;
	 private List<OrdineDTO> ordini;
	 private List<RecensioneDTO> recensioni;
	 
	public UtenteDTO(Integer id, String nome, String cognome, String email, String password, String ruolo,
			CarrelloDTO carrello, List<OrdineDTO> ordini, List<RecensioneDTO> recensioni) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
		this.carrello = carrello;
		this.ordini = ordini;
		this.recensioni = recensioni;
	}

	public UtenteDTO() {
		super();
	}

	@Override
	public String toString() {
		return "UtenteDTO [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password="
				+ password + ", ruolo=" + ruolo + carrello + ", ordini=" + ordini
				+ ", recensioni=" + recensioni + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public CarrelloDTO getCarrello() {
		return carrello;
	}

	public void setCarrello(CarrelloDTO carrello) {
		this.carrello = carrello;
	}

	public List<OrdineDTO> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<OrdineDTO> ordini) {
		this.ordini = ordini;
	}

	public List<RecensioneDTO> getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(List<RecensioneDTO> recensioni) {
		this.recensioni = recensioni;
	}
	 
	
	 
	 

}
