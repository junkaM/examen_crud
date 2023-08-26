package com.examen.crud.model;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Commande {
    private int liste_commande_id;
    private Date date_de_commande;
}
