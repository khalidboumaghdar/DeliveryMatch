package com.aplication.deliverymatch1.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Statistique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private long totalUtilisateurs;
    private long totalAnnonces;
    private long totalDemandes;
    private double tauxAcceptation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getTotalUtilisateurs() {
        return totalUtilisateurs;
    }

    public void setTotalUtilisateurs(long totalUtilisateurs) {
        this.totalUtilisateurs = totalUtilisateurs;
    }

    public long getTotalAnnonces() {
        return totalAnnonces;
    }

    public void setTotalAnnonces(long totalAnnonces) {
        this.totalAnnonces = totalAnnonces;
    }

    public long getTotalDemandes() {
        return totalDemandes;
    }

    public void setTotalDemandes(long totalDemandes) {
        this.totalDemandes = totalDemandes;
    }

    public double getTauxAcceptation() {
        return tauxAcceptation;
    }

    public void setTauxAcceptation(double tauxAcceptation) {
        this.tauxAcceptation = tauxAcceptation;
    }
}
