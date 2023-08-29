package com.examen.crud.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String numeroTelephone;
}