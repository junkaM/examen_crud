package com.examen.crud.service.listeCommande;

import com.examen.crud.model.ListeCommande;
import com.examen.crud.repository.listeCommande.ListeCommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListeCommandeServiceImpl implements ListeCommandeService{
    public final ListeCommandeRepository listeCommandeRepository;

    public ListeCommandeServiceImpl(ListeCommandeRepository listeCommandeRepository) {
        this.listeCommandeRepository = listeCommandeRepository;
    }

    @Override
    public ListeCommande findById(int id){
        return listeCommandeRepository.findById(id);
    }

    @Override
    public List<ListeCommande> findAll(){
        return listeCommandeRepository.findAll();
    }

    @Override
    public void add(ListeCommande listeCommande){
        listeCommandeRepository.add(listeCommande);
    }
    @Override
    public void update(ListeCommande listeCommande, int id){
        listeCommandeRepository.update(listeCommande, id);
    }

    @Override
    public  void delete(int id){
        listeCommandeRepository.delete(id);
    }

}
