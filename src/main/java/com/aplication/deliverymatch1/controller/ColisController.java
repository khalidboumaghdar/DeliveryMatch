package com.aplication.deliverymatch1.controller;

import com.aplication.deliverymatch1.entity.Colis;
import com.aplication.deliverymatch1.service.ColisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colis")
public class ColisController {

    private final ColisService colisService;

    public ColisController(ColisService colisService) {
        this.colisService = colisService;
    }

    @PostMapping
    public ResponseEntity<Colis> createColis(@RequestBody Colis colis) {
        return ResponseEntity.ok(colisService.createColis(colis));
    }

    @GetMapping
    public List<Colis> getAllColis() {
        return colisService.getAllColis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colis> getColisById(@PathVariable Long id) {
        return ResponseEntity.ok(colisService.getColisById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteColis(@PathVariable Long id) {
        colisService.deleteColis(id);
        return ResponseEntity.ok("Colis supprimé");
    }
}
