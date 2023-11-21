package com.example.unit_test.repository;

import com.example.unit_test.model.Categorie;
import com.example.unit_test.model.Produs;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ProdusRepository {

    private final Set<Produs> produsSet = new HashSet<>();

    public ProdusRepository(){
        produsSet.add(new Produs("Ciocolata",6.99, Categorie.ALIMENTAR));
        produsSet.add(new Produs("Tricou",98.99, Categorie.VESTIMENTAR));
        produsSet.add(new Produs("Masa",150.69, Categorie.GRADINA));
        produsSet.add(new Produs("Frigider",2699.99, Categorie.ELECTORCASNIC));
        produsSet.add(new Produs("Parchet",89.39, Categorie.MATERIAL_CONSTRUCTIE));
        produsSet.add(new Produs("Biscuiti",16.99, Categorie.ALIMENTAR));
        produsSet.add(new Produs("Masina de spalat vase",2999.29, Categorie.ELECTORCASNIC));
        produsSet.add(new Produs("Pantaloni",236.99, Categorie.VESTIMENTAR));
        produsSet.add(new Produs("Scaun",136.99, Categorie.GRADINA));
    }

    public Set<Produs> getProduse(){
        return produsSet;
    }

}
