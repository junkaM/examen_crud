package com.examen.crud.repository.client;

import com.examen.crud.JDBC.ConnectionDB;
import com.examen.crud.model.Client;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcClientRepository implements ClientRepository{
    private final ConnectionDB connectionDB;

    public JdbcClientRepository(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public Client findById(int id) {
        Client client = null;
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("SELECT * FROM client WHERE client_id = ?");
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    client = new Client(
                            resultSet.getInt("client_id"),
                            resultSet.getString("nom"),
                            resultSet.getString("prenom"),
                            resultSet.getString("adresse"),
                            resultSet.getString("numero_telephone")
                    );
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("SELECT * FROM client");
             ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("client_id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("adresse"),
                        resultSet.getString("numero_telephone")
                );
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
    @Override
    public void add(Client client) {
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("INSERT INTO client (nom, prenom, adresse, numero_telephone) VALUES (?, ?, ?, ?)");
        ) {
            statement.setString(1, client.getNom());
            statement.setString(2, client.getPrenom());
            statement.setString(3, client.getAdresse());
            statement.setString(4, client.getNumeroTelephone());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client client, int id) {
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("UPDATE client SET nom = ?, prenom = ?, adresse = ?, numero_telephone = ? WHERE client_id = ?");
        ) {
            statement.setString(1, client.getNom());
            statement.setString(2, client.getPrenom());
            statement.setString(3, client.getAdresse());
            statement.setString(4, client.getNumeroTelephone());
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("DELETE FROM Client WHERE id = ?");
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
