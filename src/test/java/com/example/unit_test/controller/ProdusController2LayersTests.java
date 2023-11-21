package com.example.unit_test.controller;

import com.example.unit_test.model.Categorie;
import com.example.unit_test.model.Produs;
import com.example.unit_test.repository.ProdusRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdusController2LayersTests {

    @Autowired
    public MockMvc  mockMvc;

    @MockBean
    public ProdusRepository produsRepository;

    @Test
    public void getExpectedStockValue() throws Exception {

        final Set<Produs> produse = new HashSet<>();
        produse.add(new Produs("a",19, Categorie.ALIMENTAR));
        produse.add(new Produs("b",2.10, Categorie.GRADINA));
        produse.add(new Produs("c",100.99, Categorie.ELECTORCASNIC));
        produse.add(new Produs("d",25, Categorie.ALIMENTAR));
        when(produsRepository.getProduse()).thenReturn(produse);

        mockMvc.perform(MockMvcRequestBuilders.get("/produse/getStockValue"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").value(147.09));

        verify(produsRepository,times(1)).getProduse();
    }


}
