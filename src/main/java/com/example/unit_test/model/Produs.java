package com.example.unit_test.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Produs {

    private String denumire;
    private double pret;
    private Categorie categorie;
}
