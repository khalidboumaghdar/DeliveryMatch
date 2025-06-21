package com.aplication.deliverymatch1.repository;

import com.aplication.deliverymatch1.entity.Demande;
import com.aplication.deliverymatch1.entity.StatutDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {

    long countByStatut(StatutDemande statut);

}
