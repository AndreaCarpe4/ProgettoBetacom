package com.betacom.fe.dto;
import java.util.List;





public class ProdottoDTO {

    private Integer id;
    private String marca;
    private String nome;
    private String categoria;
    private String descrizione;
    private Double prezzo;
    private Integer quantitaDisponibile;
    private String urlImg;
    private String size;
    private String colore;
    private List<CarrelloDTO> carrelli;
    private List<OrdineDTO> ordini;
    private List<RecensioneDTO> recensioni;



	public ProdottoDTO(Integer id, String marca, String nome, String categoria, String descrizione, Double prezzo,
			Integer quantitaDisponibile, String urlImg, String size, String colore, List<CarrelloDTO> carrelli,
			List<OrdineDTO> ordini, List<RecensioneDTO> recensioni) {
		super();
		this.id = id;
		this.marca = marca;
		this.nome = nome;
		this.categoria = categoria;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantitaDisponibile = quantitaDisponibile;
		this.urlImg = urlImg;
		this.size = size;
		this.colore = colore;
		this.carrelli = carrelli;
		this.ordini = ordini;
		this.recensioni = recensioni;
	}


	public ProdottoDTO() {
		super();
	}


    public ProdottoDTO(ProdottoDTO prodotto) {
        this.id = prodotto.getId();
        this.nome = prodotto.getNome();
        this.descrizione = prodotto.getDescrizione();
        this.prezzo = prodotto.getPrezzo();
        this.categoria = prodotto.getCategoria();
    }



	public ProdottoDTO(String marca, String nome, String categoria, String descrizione, Double prezzo, String urlImg,
			String colore) {
		super();
		this.marca = marca;
		this.nome = nome;
		this.categoria = categoria;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.urlImg = urlImg;
		this.colore = colore;
	}
	@Override
	public String toString() {
		return "ProdottoDTO [id=" + id + ", marca=" + marca + ", nome=" + nome + ", categoria=" + categoria
				+ ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", quantitaDisponibile=" + quantitaDisponibile
				+ ", urlImg=" + urlImg + ", size=" + size + ", colore=" + colore + ", carrelli=" + carrelli
				+ ", ordini=" + ordini + ", recensioni=" + recensioni + "]";
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getQuantitàDisponibile() {
		return quantitaDisponibile;
	}

	public void setQuantitàDisponibile(Integer quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}


	public List<CarrelloDTO> getCarrelli() {
		return carrelli;
	}

	public void setCarrelli(List<CarrelloDTO> carrelli) {
		this.carrelli = carrelli;
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