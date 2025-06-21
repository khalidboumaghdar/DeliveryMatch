package com.aplication.deliverymatch1.service;

import com.aplication.deliverymatch1.entity.Colis;
import com.aplication.deliverymatch1.repository.ColisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColisService {

    private final ColisRepository colisRepository;

    public ColisService(ColisRepository colisRepository) {
        this.colisRepository = colisRepository;
    }

    public Colis createColis(Colis colis) {
        return colisRepository.save(colis);
    }

    public List<Colis> getAllColis() {
        return colisRepository.findAll();
    }

    public Colis getColisById(Long id) {
        return colisRepository.findById(id).orElseThrow();
    }

    public void deleteColis(Long id) {
        colisRepository.deleteById(id);
    }
}