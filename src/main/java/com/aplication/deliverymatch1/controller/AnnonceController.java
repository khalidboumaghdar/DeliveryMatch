package com.aplication.deliverymatch1.controller;

import com.aplication.deliverymatch1.entity.Annonce;
import com.aplication.deliverymatch1.service.AnnonceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/annonces")
public class AnnonceController {

    private final AnnonceService annonceService;

    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @PostMapping("/create")
    public ResponseEntity<Annonce> createAnnonce(@RequestBody Annonce annonce) {
        return ResponseEntity.ok(annonceService.createAnnonce(annonce));
    }

    @GetMapping
    public List<Annonce> getAllAnnonces() {
        return annonceService.getAllAnnonces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Annonce> getAnnonceById(@PathVariable Long id) {
        return ResponseEntity.ok(annonceService.getAnnonceById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnnonce(@PathVariable Long id) {
        annonceService.deleteAnnonce(id);
        return ResponseEntity.ok("Annonce supprimée");
    }
}