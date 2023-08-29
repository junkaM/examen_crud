package com.examen.crud.repository.paiement;

import com.examen.crud.model.Paiement;

import java.util.List;

public interface PaiementRepository {
    Paiement findById(int id);

    List<Paiement> findAll();

    void add(Paiement paiement);

    void update(Paiement paiement, int id);

    void delete(int id);
}
