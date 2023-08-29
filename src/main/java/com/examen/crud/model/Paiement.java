package com.examen.crud.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Paiement {
    private int paiementId;
    private Float montant;
    private String modePaiement;
    private  int idCommande;
}
