package org.Archi_Logicielle.dao;

import org.Archi_Logicielle.DatabaseConnection;
import org.Archi_Logicielle.model.Classe;
import java.sql.*;

public class ClasseDAO {
    public void addClasse(Classe classe) {
        String sql = "INSERT INTO classe (promotion, specialite) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, classe.getPromotion());
            stmt.setString(2, classe.getSpecialite());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClasse(Classe classe) {
        String sql = "UPDATE classe SET promotion = ?, specialite = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, classe.getPromotion());
            stmt.setString(2, classe.getSpecialite());
            stmt.setInt(3, classe.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClasse(int id) {
        String sql = "DELETE FROM classe WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
