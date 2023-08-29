package com.examen.crud.model;


import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Commande {
    private int listeCommandeId;
    private Timestamp dateDeCommande;
    private int ClientId;
    private int CommandeId;
}
