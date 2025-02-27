package com.betacom.fe.dto;

import java.util.Date;

public class PagamentoDTO {

	private Integer id;
    private String metodoDiPagamento;
    private String numeroCarta;
    private Date dataScadenza;
    private String cvv;
    private Integer userId;
    
    


	public PagamentoDTO(Integer id, String metodoDiPagamento, String numeroCarta, Date dataScadenza, String cvv,
			Integer userId) {
		super();
		this.id = id;
		this.metodoDiPagamento = metodoDiPagamento;
		this.numeroCarta = numeroCarta;
		this.dataScadenza = dataScadenza;
		this.cvv = cvv;
		this.userId = userId;
	}


	public PagamentoDTO() {
		super();
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public Date getDataScadenza() {
		return dataScadenza;
	}


	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMetodoDiPagamento() {
		return metodoDiPagamento;
	}

	public void setMetodoDiPagamento(String metodoDiPagamento) {
		this.metodoDiPagamento = metodoDiPagamento;
	}


	public String getNumeroCarta() {
	    if (numeroCarta == null) {
	        return "**** **** **** ****";  // Valore predefinito quando numeroCarta è null
	    }
	    // Se la lunghezza del numero è inferiore a 4, restituisci comunque gli ultimi 4 caratteri disponibili
	    int length = numeroCarta.length();
	    String last4Digits = length >= 4 ? numeroCarta.substring(length - 4) : numeroCarta;
	    return "**** **** **** " + last4Digits;
	}



	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

    
    

}