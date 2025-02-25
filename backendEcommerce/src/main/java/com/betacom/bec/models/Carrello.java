package com.betacom.bec.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="carrello")
public class Carrello {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer quantita;
    
    private Double prezzo;
    
    @OneToOne
    @JoinColumn(name = "id_ordine")
    private Ordine ordine;
    
	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	@OneToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @OneToMany(mappedBy = "carrello", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference 
    private List<CarrelloProdotto> carrelloProdotti;


    public void aggiornaTotali() {
        this.quantita = carrelloProdotti.stream()
            .mapToInt(CarrelloProdotto::getQuantita)
            .sum();

        this.prezzo = carrelloProdotti.stream()
            .mapToDouble(cp -> cp.getProdotto().getPrezzo() * cp.getQuantita())
            .sum();
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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<CarrelloProdotto> getCarrelloProdotti() {
		return carrelloProdotti;
	}

	public void setCarrelloProdotti(List<CarrelloProdotto> carrelloProdotti) {
		this.carrelloProdotti = carrelloProdotti;
	}

    
}


	