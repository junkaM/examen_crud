package com.examen.crud.repository.produit;

import com.examen.crud.JDBC.ConnectionDB;
import com.examen.crud.model.Produit;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcProduitRepository implements ProduitRepository {
    private final ConnectionDB connectionDB;


    public JdbcProduitRepository(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public Produit findById(int id) {
        Produit produit = null;
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("SELECT * FROM produit WHERE id = ?");
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    produit = new Produit(
                            resultSet.getInt("id"),
                            resultSet.getString("nom"),
                            resultSet.getString("description"),
                            resultSet.getFloat("prix_unitaire"),
                            resultSet.getInt("stock")
                    );
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = new ArrayList<>();
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("SELECT * FROM produit");
             ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                Produit produit = new Produit(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("description"),
                        resultSet.getFloat("prix_unitaire"),
                        resultSet.getInt("stock")
                );
                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public void add(Produit produit) {
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("INSERT INTO produit (nom, description, prix_unitaire, stock) VALUES (?, ?, ?, ?)");
        ) {
            statement.setString(1, produit.getNom());
            statement.setString(2, produit.getDescription());
            statement.setDouble(3, produit.getPrixUnitaire());
            statement.setInt(4, produit.getStock());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Produit produit) {
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("UPDATE produit SET nom = ?, description = ?, prix_unitaire = ?, stock = ? WHERE id = ?");
        ) {
            statement.setString(1, produit.getNom());
            statement.setString(2, produit.getDescription());
            statement.setDouble(3, produit.getPrixUnitaire());
            statement.setInt(4, produit.getStock());
            statement.setLong(5, produit.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (
             PreparedStatement statement = connectionDB.getConnection().prepareStatement("DELETE FROM produit WHERE id = ?");
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

}
