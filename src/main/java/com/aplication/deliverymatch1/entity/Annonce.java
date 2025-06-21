package com.aplication.deliverymatch1.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lieuDepart;
    private String destinationFinale;
    private String etapesIntermediaires;

    private String dimensionsMax;
    private String typeMarchandise;
    private int capaciteDisponible;

    private LocalDate datePublication = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "conducteur_id")
    private User conducteur;

    @OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
    private List<Demande> demandes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getDestinationFinale() {
        return destinationFinale;
    }

    public void setDestinationFinale(String destinationFinale) {
        this.destinationFinale = destinationFinale;
    }

    public String getEtapesIntermediaires() {
        return etapesIntermediaires;
    }

    public void setEtapesIntermediaires(String etapesIntermediaires) {
        this.etapesIntermediaires = etapesIntermediaires;
    }

    public String getDimensionsMax() {
        return dimensionsMax;
    }

    public void setDimensionsMax(String dimensionsMax) {
        this.dimensionsMax = dimensionsMax;
    }

    public String getTypeMarchandise() {
        return typeMarchandise;
    }

    public void setTypeMarchandise(String typeMarchandise) {
        this.typeMarchandise = typeMarchandise;
    }

    public int getCapaciteDisponible() {
        return capaciteDisponible;
    }

    public void setCapaciteDisponible(int capaciteDisponible) {
        this.capaciteDisponible = capaciteDisponible;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public User getConducteur() {
        return conducteur;
    }

    public void setConducteur(User conducteur) {
        this.conducteur = conducteur;
    }

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}
