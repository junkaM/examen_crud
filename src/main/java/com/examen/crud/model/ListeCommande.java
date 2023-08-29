package com.examen.crud.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class ListeCommande {
    private int listeCommandeId;
    private int quantite;
    private int produitId;
}
