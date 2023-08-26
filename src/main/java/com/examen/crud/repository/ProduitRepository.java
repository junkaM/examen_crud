package com.examen.crud.repository;

import com.examen.crud.model.Produit;

import java.util.List;

public interface ProduitRepository {

    Produit findById(int id);
    List<Produit> findAll();
    void add(Produit produit);
    void update(Produit produit);
    void delete(int id);
}
