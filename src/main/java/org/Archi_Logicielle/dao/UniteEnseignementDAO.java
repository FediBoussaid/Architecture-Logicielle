package org.Archi_Logicielle.dao;

import org.Archi_Logicielle.model.UniteEnseignement;
import org.Archi_Logicielle.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UniteEnseignementDAO {

    public void addUniteEnseignement(UniteEnseignement unite) {
        String sql = "INSERT INTO unite_enseignement (code, designation) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, unite.getCode());
            statement.setString(2, unite.getDesignation());
            statement.executeUpdate();
            System.out.println("Unité d'enseignement ajoutée avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
