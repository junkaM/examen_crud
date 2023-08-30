package com.examen.crud.repository.paiement;

import com.examen.crud.JDBC.ConnectionDB;
import com.examen.crud.model.Paiement;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcPaiementRepository implements PaiementRepository{
    private final ConnectionDB connectionDB;

    public JdbcPaiementRepository(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public Paiement findById(int id) {
        Paiement paiement = null;
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("SELECT * FROM paiement WHERE paiement_id = ?");
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    paiement = new Paiement(
                            resultSet.getInt("paiement_id"),
                            resultSet.getFloat("montant"),
                            resultSet.getString("mode_paiement"),
                            resultSet.getInt("liste_commande_id_commande")
                    );
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paiement;
    }


    @Override
    public List<Paiement> findAll() {
        List<Paiement> paiements = new ArrayList<>();
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("SELECT * FROM paiement");
             ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                Paiement paiement = new Paiement(

                        resultSet.getInt("paiement_id"),
                        resultSet.getFloat("montant"),
                        resultSet.getString("mode_paiement"),
                        resultSet.getInt("liste_commande_id_commande")
                );
                paiements.add(paiement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paiements;
    }


    @Override
    public void add(Paiement paiement) {
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("INSERT INTO paiement (montant, mode_paiement, liste_commande_id_commande) VALUES (?, ?, ?)");
        ) {
            statement.setDouble(1, paiement.getMontant());
            statement.setString(2, paiement.getModePaiement());
            statement.setInt(3, paiement.getIdCommande());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Paiement paiement, int id) {
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("UPDATE paiement SET montant = ?, mode_paiement = ?, liste_commande_id_commande = ? WHERE paiement_id = ?");
        ) {
            statement.setDouble(1, paiement.getMontant());
            statement.setString(2, paiement.getModePaiement());
            statement.setInt(3, paiement.getIdCommande());
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("DELETE FROM paiement WHERE paiement_id = ?");
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
