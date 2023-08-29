DROP DATABASE IF EXISTS star;
CREATE DATABASE star;

\c star;

CREATE TABLE Client (
    client_id SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    adresse VARCHAR(50),
    numero_telephone VARCHAR(20)
);   

CREATE TABLE liste_commande (
    liste_commande_id SERIAL PRIMARY KEY,
    quantite INT,
    produit_id_produit INT,
    FOREIGN KEY (produit_id_produit) REFERENCES produit(produit_id)
);

CREATE TABLE produit (
    produit_id SERIAL PRIMARY KEY,
    nom VARCHAR(50),
    description TEXT,
    prix_unitaire DOUBLE PRECISION,
    stock INT
);

CREATE TABLE commande (
    liste_commande_id SERIAL,
    date_de_commande DATE,
    client_id_Client SERIAL,
    liste_commande_id_liste_commande INT,
    PRIMARY KEY (liste_commande_id),
    FOREIGN KEY (client_id_Client) REFERENCES Client(client_id),
    FOREIGN KEY (liste_commande_id_liste_commande) REFERENCES liste_commande(liste_commande_id)
);

CREATE TABLE paiement (
    paiement_id SERIAL PRIMARY KEY,
    montant DOUBLE PRECISION,
    mode_paiement VARCHAR(20),
    liste_commande_id_commande INT,
    FOREIGN KEY (liste_commande_id_commande) REFERENCES commande(liste_commande_id)
);

-- Inserts pour la table Client
INSERT INTO Client (nom, prenom, adresse, numero_telephone)
VALUES ('Doe', 'John', '123 Main St', '555-1234'),
       ('Smith', 'Jane', '456 Elm St', '555-5678'),
       ('Johnson', 'Michael', '789 Oak St', '555-9876');

-- Inserts pour la table liste_commande
INSERT INTO liste_commande (quantite, produit_id_produit)
VALUES (2, 1),
       (3, 2),
       (1, 3);

-- Inserts pour la table produit
INSERT INTO produit (nom, description, prix_unitaire, stock)
VALUES ('Eau minérale', 'Eau minérale naturelle', 1.50, 100),
       ('Café', 'Café arabica torréfié', 3.00, 50),
       ('Soda', 'Soda gazeux saveur cola', 2.00, 75);

-- Inserts pour la table commande
INSERT INTO commande (liste_commande_id, date_de_commande, client_id_Client, liste_commande_id_liste_commande)
VALUES (1, '2023-08-01', 1, 1),
       (2, '2023-08-02', 2, 2),
       (3, '2023-08-03', 3, 3);

-- Inserts pour la table paiement
INSERT INTO paiement (montant, mode_paiement, liste_commande_id_commande)
VALUES (50.00, 'Mvola', 1),
       (30.00, 'Airtel Money', 2),
       (25.00, 'Orange Money', 3);
