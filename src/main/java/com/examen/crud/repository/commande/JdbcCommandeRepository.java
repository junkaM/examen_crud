package com.examen.crud.repository.commande;

import com.examen.crud.JDBC.ConnectionDB;
import com.examen.crud.model.Commande;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcCommandeRepository implements CommandeRepository{
    private final ConnectionDB connectionDB;

    public JdbcCommandeRepository(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public Commande findById(int id) {
        Commande commande = null;
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM commande WHERE liste_commande_id = ?");
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    commande = new Commande(
                            resultSet.getInt("liste_commande_id"),
                            resultSet.getTimestamp("date_de_commande"),
                            resultSet.getInt("client_id_client"),
                            resultSet.getInt("liste_commande_id_liste_commande")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commande;
    }

    @Override
    public List<Commande> findAll() {
        List<Commande> commandes = new ArrayList<>();
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM commande");
             ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                Commande commande = new Commande(
                        resultSet.getInt("liste_commande_id"),
                        resultSet.getTimestamp("date_de_commande"),
                        resultSet.getInt("client_id_client"),
                        resultSet.getInt("liste_commande_id_liste_commande")
                );
                commandes.add(commande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }
    @Override
    public void add(Commande commande) {
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO commande (date_de_commande, client_id_client, liste_commande_id_liste_commande) VALUES (?, ?, ?)");
        ) {
            statement.setTimestamp(1, commande.getDateDeCommande());
            statement.setInt(2, commande.getClientId());
            statement.setInt(3, commande.getListeCommandeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Commande commande, int id) {
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE commande SET date_de_commande = ?, client_id_client = ?, liste_commande_id_liste_commande = ? WHERE liste_commande_id = ?");
        ) {
            statement.setTimestamp(1, commande.getDateDeCommande());
            statement.setInt(2, commande.getClientId());
            statement.setInt(3, commande.getCommandeId());
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        try (Connection connection = connectionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM commande WHERE liste_commande_id = ?");
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
