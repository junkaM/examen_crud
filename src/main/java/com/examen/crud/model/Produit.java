package com.examen.crud.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Produit {
    private int id;
    private String nom;
    private String description;
    private Float prixUnitaire;
    private int stock;
}
