package com.aplication.deliverymatch1.service;

import com.aplication.deliverymatch1.entity.Demande;
import com.aplication.deliverymatch1.entity.StatutDemande;
import com.aplication.deliverymatch1.repository.DemandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeService {

    private final DemandeRepository demandeRepository;

    public DemandeService(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    public Demande createDemande(Demande demande) {
        return demandeRepository.save(demande);
    }

    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    public void updateStatut(Long id, String statut) {
        Demande demande = demandeRepository.findById(id).orElseThrow();
        demande.setStatut(StatutDemande.valueOf(statut.toUpperCase()));
        demandeRepository.save(demande);
    }

    public void deleteDemande(Long id) {
        demandeRepository.deleteById(id);
    }
}