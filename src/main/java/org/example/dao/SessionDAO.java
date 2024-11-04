package org.example.dao;

import org.example.DatabaseConnection;
import org.example.model.Session;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessionDAO {
    public void addSession(Session session) {
        String sql = "INSERT INTO session (identifiant, id_ue, id_classe, id_creneau) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, session.getIdentifiant());
            stmt.setInt(2, session.getIdUE());
            stmt.setInt(3, session.getIdClasse());
            stmt.setInt(4, session.getIdCreneau());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSession(Session session) {
        String sql = "UPDATE session SET identifiant = ?, id_ue = ?, id_classe = ?, id_creneau = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, session.getIdentifiant());
            stmt.setInt(2, session.getIdUE());
            stmt.setInt(3, session.getIdClasse());
            stmt.setInt(4, session.getIdCreneau());
            stmt.setInt(5, session.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSession(int id) {
        String sql = "DELETE FROM session WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
