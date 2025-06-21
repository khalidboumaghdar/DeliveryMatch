package com.aplication.deliverymatch1.service;

import com.aplication.deliverymatch1.entity.Annonce;
import com.aplication.deliverymatch1.repository.AnnonceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceService {

    private final AnnonceRepository annonceRepository;

    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public Annonce createAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    public Annonce getAnnonceById(Long id) {
        return annonceRepository.findById(id).orElseThrow();
    }

    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }
}