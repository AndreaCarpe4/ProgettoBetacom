package com.betacom.bec.dto;

import java.sql.Timestamp;

public class PagamentoDTO {

	private Integer id;
    private String metodoDiPagamento;
    private String statoPagamento;
    private Double importo;
    private Timestamp dataPagamento;
    
	public PagamentoDTO(Integer id,  String metodoDiPagamento, String statoPagamento, Double importo,
			Timestamp dataPagamento) {
		super();
		this.id = id;
		this.metodoDiPagamento = metodoDiPagamento;
		this.statoPagamento = statoPagamento;
		this.importo = importo;
		this.dataPagamento = dataPagamento;
	}

	public PagamentoDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PagamentoDTO [id=" + id  + ", metodoDiPagamento=" + metodoDiPagamento
				+ ", statoPagamento=" + statoPagamento + ", importo=" + importo + ", dataPagamento=" + dataPagamento
				+ "]";
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

	public String getStatoPagamento() {
		return statoPagamento;
	}

	public void setStatoPagamento(String statoPagamento) {
		this.statoPagamento = statoPagamento;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public Timestamp getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Timestamp dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
    
    

}
