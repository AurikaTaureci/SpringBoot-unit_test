package com.example.unit_test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static com.example.unit_test.model.Categorie.ALIMENTAR;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProdusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getProduseByCategorie() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.
                        get("/produse/category/{name}", ALIMENTAR))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$.[*].denumire").value(containsInAnyOrder("Ciocolata","Biscuiti")));
    }

    @Test
    void getProduse() {
    }
}
















