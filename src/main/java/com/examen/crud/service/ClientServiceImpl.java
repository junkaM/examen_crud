package com.examen.crud.service;

import com.examen.crud.model.Client;
import com.examen.crud.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{
    public final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(int id){
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @Override
    public void add(Client client){
        clientRepository.add(client);
    }
    @Override
    public void update(Client client, int id){
        clientRepository.update(client, id);
    }

    @Override
    public  void delete(int id){
        clientRepository.delete(id);
    }

}
