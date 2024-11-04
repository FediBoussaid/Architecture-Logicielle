package org.example.dao;

import org.example.DatabaseConnection;
import org.example.model.Creneau;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CreneauDAO {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void addCreneau(Creneau creneau) {
        String sql = "INSERT INTO creneau (debut, fin) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, creneau.getDebut().format(formatter));
            stmt.setString(2, creneau.getFin().format(formatter));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCreneau(Creneau creneau) {
        String sql = "UPDATE creneau SET debut = ?, fin = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, creneau.getDebut().format(formatter));
            stmt.setString(2, creneau.getFin().format(formatter));
            stmt.setInt(3, creneau.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCreneau(int id) {
        String sql = "DELETE FROM creneau WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
