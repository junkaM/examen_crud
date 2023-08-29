package com.examen.crud.controller;

import com.examen.crud.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.examen.crud.service.ProduitService;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/getById/{id}")
    public Produit getProduitById(@PathVariable int id) {
        return produitService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Produit> getAllProduits() {
        return produitService.findAll();
    }

    @PostMapping("/add")
    public void addProduit(@RequestBody Produit produit) {
        produitService.add(produit);
    }

    @PutMapping("/update/{id}")
    public void updateProduit(@PathVariable int id, @RequestBody Produit produit) {
        produit.setId(id);
        produitService.update(produit);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduit(@PathVariable int id) {
        produitService.delete(id);
    }
}
