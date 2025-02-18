package com.betacom.fe.request;

public class UtenteReq {

	 private Integer id;
	 private String nome;
	 private String cognome;
	 private String email;
	 private String userName;
	 private String password;
	 private String ruolo;
	 private String numeroTelefono;
	 private String indirizzoDiSpedizione;
	 private String indirizzoDiFatturazione;





	public UtenteReq(Integer id, String nome, String cognome, String email, String userName, String password,
			String ruolo, String numeroTelefono, String indirizzoDiSpedizione, String indirizzoDiFatturazione) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.ruolo = ruolo;
		this.numeroTelefono = numeroTelefono;
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
		this.indirizzoDiFatturazione = indirizzoDiFatturazione;
	}

	public UtenteReq() {
		super();
	}

	@Override
	public String toString() {
		return "UtenteReq [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", userName="
				+ userName + ", password=" + password + ", ruolo=" + ruolo + ", numeroTelefono=" + numeroTelefono
				+ ", indirizzoDiSpedizione=" + indirizzoDiSpedizione + ", indirizzoDiFatturazione="
				+ indirizzoDiFatturazione + "]";
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
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



	public String getNumeroTelefono() {
		return numeroTelefono;
	}



	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}



	public String getIndirizzoDiSpedizione() {
		return indirizzoDiSpedizione;
	}



	public void setIndirizzoDiSpedizione(String indirizzoDiSpedizione) {
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
	}



	public String getIndirizzoDiFatturazione() {
		return indirizzoDiFatturazione;
	}



	public void setIndirizzoDiFatturazione(String indirizzoDiFatturazione) {
		this.indirizzoDiFatturazione = indirizzoDiFatturazione;
	}

	
	 
}