package src.com.unibuc.pao.proiect.service;
import src.com.unibuc.pao.proiect.model.Produs;

import java.sql.*;

public class ProdusService {
    private final Connection connection;

    public ProdusService() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    public void adaugaProdus(Produs produs) {
        String sql = "INSERT INTO produs(id, nume, pret, disponibilitate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, produs.getId());
            stm.setString(2, produs.getNume());
            stm.setDouble(3, produs.getPret());
            stm.setString(4, produs.getDisponibilitate());

            stm.executeUpdate();
            System.out.println("Produs adaugat!");
        } catch (SQLException e) {
            System.out.println("Eroare la adaugare persaoan: " + e.getMessage());
        }
    }
}
