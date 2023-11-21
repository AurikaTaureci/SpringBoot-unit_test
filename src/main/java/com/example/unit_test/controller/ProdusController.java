package com.example.unit_test.controller;


import com.example.unit_test.model.Categorie;
import com.example.unit_test.model.Produs;
import com.example.unit_test.service.ProdusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/produse")
public class ProdusController {

   ProdusService produsService;

    public ProdusController(ProdusService produsService) {
        this.produsService = produsService;
    }

    @GetMapping("/category/{name}")
        public Set<Produs> getProduseByCategorie(@PathVariable(name = "name") Categorie categorie){
            return produsService.getProduseByCategorie(categorie);
        }

    @GetMapping("/getAll")
        public Set<Produs>getProduse(){
            return produsService.getProduse();
    }

    @GetMapping("/getStockValue")
    public double getStockValue(){
        return produsService.getStockValue();
    }

}













