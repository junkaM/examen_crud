package com.examen.crud.repository.listeCommande;

import com.examen.crud.JDBC.ConnectionDB;
import com.examen.crud.model.ListeCommande;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcListeCommandeRepository implements ListeCommandeRepository{
    private final ConnectionDB connectionDB;

    public JdbcListeCommandeRepository(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public ListeCommande findById(int id) {
        ListeCommande listeCommande = null;
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM liste_commande WHERE liste_commande_id = ?");
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    listeCommande = new ListeCommande(
                            resultSet.getInt("liste_commande_id"),
                            resultSet.getInt("quantite"),
                            resultSet.getInt("produit_id_produit")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeCommande;
    }

    @Override
    public List<ListeCommande> findAll() {
        List<ListeCommande> listeCommandes = new ArrayList<>();
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM liste_commande");
             ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                ListeCommande listeCommande = new ListeCommande(
                        resultSet.getInt("liste_commande_id"),
                        resultSet.getInt("quantite"),
                        resultSet.getInt("produit_id_produit")
                );
                listeCommandes.add(listeCommande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeCommandes;
    }
    @Override
    public void add(ListeCommande listeCommande) {
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO liste_commande (quantite, produit_id_produit) VALUES (?, ?)");
        ) {
            statement.setInt(1, listeCommande.getQuantite());
            statement.setInt(2, listeCommande.getProduitId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ListeCommande listeCommande, int id) {
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE liste_commande SET quantite = ?, produit_id_produit = ? WHERE liste_commande_id = ?");
        ) {
            statement.setInt(1, listeCommande.getQuantite());
            statement.setInt(2, listeCommande.getProduitId());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM liste_commande WHERE liste_commande_id = ?");
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
