package com.example.unit_test.service;

import com.example.unit_test.model.Categorie;
import com.example.unit_test.model.Produs;
import com.example.unit_test.repository.ProdusRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProdusService {

    private final ProdusRepository produsRepository;

    public ProdusService(ProdusRepository produsRepository) {
        this.produsRepository = produsRepository;
    }

    public Set<Produs> getProduseByCategorie(Categorie categorie){

        final Set<Produs> produse =produsRepository.getProduse();

        return produse.stream().filter(p->p.getCategorie().equals(categorie))
                .collect(Collectors.toSet());

    }

    public double getStockValue(){
        return produsRepository.getProduse()
                .stream()
                .map(p->p.getPret())
                .reduce(0.0,Double::sum); // operatie terminala care intoare un double
    }
    public Set<Produs> getProduse(){
        return  produsRepository.getProduse();
    }
}
