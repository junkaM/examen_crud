package com.examen.crud.service;


import com.examen.crud.model.Produit;
import com.examen.crud.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit findById(int id) {
        return produitRepository.findById(id);
    }

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public void add(Produit produit) {
        produitRepository.add(produit);
    }

    @Override
    public void update(Produit produit) {
        produitRepository.update(produit);
    }

    @Override
    public void delete(int id) {
        produitRepository.delete(id);
    }
}
