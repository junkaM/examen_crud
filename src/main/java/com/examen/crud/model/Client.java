package com.examen.crud.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Client {
    private int clientId;
    private String nom;
    private String prénom;
    private String adresse;
    private String numéro_téléphone;
}