package com.betacom.fe.request;


public class PagamentoReq {

	private Integer id;
    private String metodoDiPagamento;
    private String numeroCarta;
    private Double importo;
    private String dataScadenza;
    private Integer cvv;
    private Integer userId;

	public PagamentoReq() {
		super();
	}

	public PagamentoReq(Integer id, String metodoDiPagamento, String numeroCarta, Double importo, String dataScadenza,
			Integer cvv, Integer userId) {
		super();
		this.id = id;
		this.metodoDiPagamento = metodoDiPagamento;
		this.numeroCarta = numeroCarta;
		this.importo = importo;
		this.dataScadenza = dataScadenza;
		this.cvv = cvv;
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	@Override
	public String toString() {
		return "PagamentoReq [id=" + id + ", metodoDiPagamento=" + metodoDiPagamento + ", numeroCarta=" + numeroCarta
				+ ", importo=" + importo + ", dataScadenza=" + dataScadenza + ", cvv=" + cvv + ", userId=" + userId
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

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public String getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	
    
}
