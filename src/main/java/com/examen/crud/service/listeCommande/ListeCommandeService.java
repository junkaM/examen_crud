package com.examen.crud.service.listeCommande;

import com.examen.crud.model.ListeCommande;

import java.util.List;

public interface ListeCommandeService {
    ListeCommande findById(int id);

    List<ListeCommande> findAll();

    void add(ListeCommande listeCommande);

    void update(ListeCommande listeCommande, int id);

    void delete(int id);
}
