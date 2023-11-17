package com.example.unit_test.service;

import com.example.unit_test.model.Categorie;
import com.example.unit_test.model.Produs;
import com.example.unit_test.repository.ProdusRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProdusServiceTest {

    @Autowired
        private ProdusService  produsService;

    @Mock
        private ProdusRepository produsRepository;

    Set<Produs> produse = new HashSet<>();

    @BeforeAll
    public static void beforeClass(){
        System.out.println("se executa o singura data, dupa class loads");
    }

    @BeforeEach
    public void beforeEachTestExecution(){
        System.out.println("Before each test execution");
    }

    @Test
    public void getOnlyFoodProduct(){
        final Set<Produs> prod = new HashSet<>();

        prod.add(new Produs("palarie de soare", 45.99, Categorie.VESTIMENTAR));
        prod.add(new Produs("Ceai", 15.99, Categorie.ALIMENTAR));
        prod.add(new Produs("Suc ananas", 10.50, Categorie.ALIMENTAR));
        prod.add(new Produs("Umbrela", 110.50, Categorie.GRADINA));

        when(produsRepository.getProduse()).thenReturn(prod);

        produse = produsService.getProduse();

        final Set<Produs> produseAlimentare =produsService.getProduseByCategorie(Categorie.ALIMENTAR);

        assertEquals(9,produse.size());
        assertEquals(2,produseAlimentare.size());

    }


}