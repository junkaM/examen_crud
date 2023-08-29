package com.examen.crud.controller;

import com.examen.crud.model.Commande;
import com.examen.crud.service.commande.CommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    public final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/getById/{id}")
    public Commande findById(@PathVariable int id){
        return commandeService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Commande> findAll(){
        return commandeService.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Commande commande){
        commandeService.add(commande);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Commande commande, @PathVariable int id){
        commandeService.update(commande, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        commandeService.delete(id);
    }
}
