package com.examen.crud.repository.listeCommande;

import com.examen.crud.model.ListeCommande;

import java.util.List;

public interface ListeCommandeRepository {
    ListeCommande findById(int id);

    List<ListeCommande> findAll();

    void add(ListeCommande listeCommande);

    void update(ListeCommande listeCommande, int id);

    void delete(int id);
}
