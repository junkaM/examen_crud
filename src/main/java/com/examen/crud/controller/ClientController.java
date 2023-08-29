package com.examen.crud.controller;

import com.examen.crud.model.Client;
import com.examen.crud.service.client.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    public final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getById/{id}")
    public Client findById(@PathVariable int id){
        return clientService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Client client){
        clientService.add(client);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Client client, @PathVariable int id){
        clientService.update(client, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        clientService.delete(id);
    }
}
