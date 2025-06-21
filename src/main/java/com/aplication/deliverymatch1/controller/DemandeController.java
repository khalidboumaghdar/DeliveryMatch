package com.aplication.deliverymatch1.controller;

import com.aplication.deliverymatch1.entity.Demande;
import com.aplication.deliverymatch1.service.DemandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {

    private final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @PostMapping
    public ResponseEntity<Demande> createDemande(@RequestBody Demande demande) {
        return ResponseEntity.ok(demandeService.createDemande(demande));
    }

    @GetMapping
    public List<Demande> getAllDemandes() {
        return demandeService.getAllDemandes();
    }

    @PutMapping("/{id}/statut")
    public ResponseEntity<String> updateStatutDemande(@PathVariable Long id, @RequestParam String statut) {
        demandeService.updateStatut(id, statut);
        return ResponseEntity.ok("Statut mis à jour");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDemande(@PathVariable Long id) {
        demandeService.deleteDemande(id);
        return ResponseEntity.ok("Demande supprimée");
    }
}