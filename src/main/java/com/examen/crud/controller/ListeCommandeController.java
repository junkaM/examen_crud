package com.examen.crud.controller;

import com.examen.crud.model.ListeCommande;
import com.examen.crud.service.listeCommande.ListeCommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/listeCommande")
public class ListeCommandeController {
    public final ListeCommandeService listeCommandeService;

    public ListeCommandeController(ListeCommandeService listeCommandeService) {
        this.listeCommandeService = listeCommandeService;
    }

    @GetMapping("/getById/{id}")
    public ListeCommande findById(@PathVariable int id){
        return listeCommandeService.findById(id);
    }

    @GetMapping("/getAll")
    public List<ListeCommande> findAll(){
        return listeCommandeService.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody ListeCommande listeCommande){
        listeCommandeService.add(listeCommande);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody ListeCommande listeCommande, @PathVariable int id){
        listeCommandeService.update(listeCommande, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        listeCommandeService.delete(id);
    }
}
