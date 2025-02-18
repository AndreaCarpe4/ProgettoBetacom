package com.betacom.fe.dto;

import java.util.Date;

public class PagamentoDTO {

	private Integer id;
    private String metodoDiPagamento;
    private String numeroCarta;
    private Double importo;
    private Date dataScadenza;
     
    
	public PagamentoDTO(Integer id, String metodoDiPagamento, String numeroCarta, Double importo, Date dataScadenza) {
		super();
		this.id = id;
		this.metodoDiPagamento = metodoDiPagamento;
		this.setNumeroCarta(numeroCarta);
		this.importo = importo;
		this.dataScadenza = dataScadenza;
	}


	public PagamentoDTO() {
		super();
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


	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}


	public String getNumeroCarta() {
	    return "**** **** **** " + numeroCarta.substring(numeroCarta.length() - 4);
	}


	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

    
    

}
