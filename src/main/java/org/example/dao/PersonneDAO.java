package org.example.dao;

import org.example.DatabaseConnection;
import org.example.model.Personne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAO {

    public void addPersonne(Personne personne) {
        String sql = "INSERT INTO personne (nom, prenom, type) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, personne.getNom());
            stmt.setString(2, personne.getPrenom());
            stmt.setString(3, personne.getType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePersonne(Personne personne) {
        String sql = "UPDATE personne SET nom = ?, prenom = ?, type = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, personne.getNom());
            stmt.setString(2, personne.getPrenom());
            stmt.setString(3, personne.getType());
            stmt.setInt(4, personne.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePersonne(int id) {
        String sql = "DELETE FROM personne WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Aucun enregistrement trouvé avec cet ID.");
            } else {
                System.out.println("Personne supprimée avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Personne> getAllPersonnes() {
        List<Personne> personnes = new ArrayList<>();
        String sql = "SELECT * FROM personne";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Personne personne = new Personne(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("type")
                );
                personnes.add(personne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnes;
    }
}
