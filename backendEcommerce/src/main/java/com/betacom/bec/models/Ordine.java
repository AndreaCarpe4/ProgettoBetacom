package com.betacom.bec.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;  // Import necessario
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity //tutti i db e tabelle sono entity
@Table(name = "ordini")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    @JsonBackReference  // Interrompe il ciclo di serializzazione da Ordine a Utente
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "id_carrello")
    private Carrello carrello;
    
    @OneToMany(mappedBy = "ordine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrdineProdotto> ordineProdotti;

    @Column(nullable = false)
    private Integer quantitaTotale;

    @Column(nullable = false)
    private Double prezzoTotale;

    @Column(name = "indirizzo_spedizione", length = 100, nullable = false)
    private String indirizzoDiSpedizione;

    @Column(length = 100, nullable = false)
    private String cap;

    @Column(length = 100, nullable = false)
    private String citta;

    @Column(name = "data_ordine", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOrdine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndirizzoDiSpedizione() {
        return indirizzoDiSpedizione;
    }

    public void setIndirizzoDiSpedizione(String indirizzoDiSpedizione) {
        this.indirizzoDiSpedizione = indirizzoDiSpedizione;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public Date getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}