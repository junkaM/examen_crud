package com.examen.crud.service.commande;

import com.examen.crud.model.Commande;

import java.util.List;

public interface CommandeService {
    Commande findById(int id);

    List<Commande> findAll();

    void add(Commande commande);

    void update(Commande commande, int id);

    void delete(int id);
}
