package com.aplication.deliverymatch1.repository;

import com.aplication.deliverymatch1.entity.Colis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColisRepository extends JpaRepository<Colis, Long> {
}