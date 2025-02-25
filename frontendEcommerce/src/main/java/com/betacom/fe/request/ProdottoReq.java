package com.betacom.fe.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdottoReq {

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

    public ProdottoReq(Integer id, String marca, String nome, String categoria, String descrizione, Double prezzo,
                       Integer quantitaDisponibile, String urlImg, String size, String colore) {
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
    }

    public ProdottoReq() {
    }

    @Override
    public String toString() {
        return "ProdottoReq [id=" + id + ", marca=" + marca + ", nome=" + nome + ", categoria=" + categoria
                + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", quantitaDisponibile=" + quantitaDisponibile
                + ", urlImg=" + urlImg + ", size=" + size + ", colore=" + colore + "]";
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

    public Integer getQuantitaDisponibile() {
        return quantitaDisponibile;
    }

    public void setQuantitaDisponibile(Integer quantitaDisponibile) {
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
}