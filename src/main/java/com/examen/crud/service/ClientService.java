package com.examen.crud.service;

import com.examen.crud.model.Client;

import java.util.List;

public interface ClientService {
    Client findById(int id);

    List<Client> findAll();

    void add(Client client);

    void update(Client client, int id);

    void delete(int id);
}
