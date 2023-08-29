package com.examen.crud.service.paiement;

import com.examen.crud.model.Paiement;
import com.examen.crud.repository.paiement.PaiementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService{
    public final PaiementRepository paiementRepository;

    public PaiementServiceImpl(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    @Override
    public Paiement findById(int id){
        return paiementRepository.findById(id);
    }

    @Override
    public List<Paiement> findAll(){
        return paiementRepository.findAll();
    }

    @Override
    public void add(Paiement paiement){
        paiementRepository.add(paiement);
    }
    @Override
    public void update(Paiement paiement, int id){
        paiementRepository.update(paiement, id);
    }

    @Override
    public  void delete(int id){
        paiementRepository.delete(id);
    }

}
