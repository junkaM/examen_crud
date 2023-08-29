package com.examen.crud.service.commande;

import com.examen.crud.model.Commande;
import com.examen.crud.repository.commande.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService{
    public final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Commande findById(int id){
        return commandeRepository.findById(id);
    }

    @Override
    public List<Commande> findAll(){
        return commandeRepository.findAll();
    }

    @Override
    public void add(Commande commande){
        commandeRepository.add(commande);
    }
    @Override
    public void update(Commande commande, int id){
        commandeRepository.update(commande, id);
    }

    @Override
    public  void delete(int id){
        commandeRepository.delete(id);
    }
}
