package com.examen.crud.controller;


import com.examen.crud.model.Paiement;
import com.examen.crud.service.paiement.PaiementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementController {
    public final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @GetMapping("/getById/{id}")
    public Paiement findById(@PathVariable int id){
        return paiementService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Paiement> findAll(){
        return paiementService.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Paiement paiement){
        paiementService.add(paiement);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Paiement paiement, @PathVariable int id){
        paiementService.update(paiement, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        paiementService.delete(id);
    }
}

