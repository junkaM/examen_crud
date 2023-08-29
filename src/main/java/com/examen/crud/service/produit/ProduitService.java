package com.examen.crud.service.produit;

import com.examen.crud.model.Produit;

import java.util.List;

public interface ProduitService {
    Produit findById(int id);
    List<Produit> findAll();
    void add(Produit produit);
    void update(Produit produit);
    void delete(int id);
}
