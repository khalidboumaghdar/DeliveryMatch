package com.aplication.deliverymatch1.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateDemande = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private StatutDemande statut = StatutDemande.EN_ATTENTE;

    @ManyToOne
    @JoinColumn(name = "expediteur_id")
    private User expediteur;

    @ManyToOne
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "colis_id")
    private Colis colis;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDate dateDemande) {
        this.dateDemande = dateDemande;
    }

    public StatutDemande getStatut() {
        return statut;
    }

    public void setStatut(StatutDemande statut) {
        this.statut = statut;
    }

    public User getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(User expediteur) {
        this.expediteur = expediteur;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public Colis getColis() {
        return colis;
    }

    public void setColis(Colis colis) {
        this.colis = colis;
    }
}
