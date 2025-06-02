package src.com.unibuc.pao.proiect.service;

import src.com.unibuc.pao.proiect.model.Cod;
import src.com.unibuc.pao.proiect.model.cardCredit;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CodService {
    private static CodService instance;
    private final Connection connection;

    private CodService() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    public static CodService getInstance() {
        if (instance == null) {
            instance = new CodService();
        }
        return instance;
    }

    public void adaugaCod(Cod cod) {
        String sql = "INSERT INTO codes(id, cod, valabilitate) VALUES (?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, cod.getId());
            stm.setString(2, cod.getCod());
            stm.setString(3, cod.getValabilitate());
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la adăugarea codului: " + e.getMessage());
        }
    }

    public List<Cod> getAllCodes() {
        List<Cod> coduri = new LinkedList<>();
        String sql = "SELECT * FROM codes";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String cod = rs.getString("cod");
                String valabilitate = rs.getString("valabilitate");
                coduri.add(new Cod(id, cod, valabilitate));
            }
        } catch (SQLException e) {
            System.out.println("Eroare la citirea codurilor: " + e.getMessage());
        }
        return coduri;
    }

    public void updateCod(int id, String cod, String valabilitate) {
        String sql = "UPDATE codes SET cod = ?, valabilitate = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cod);
            stmt.setString(2, valabilitate);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la modificarea codului: " + e.getMessage());
        }
    }

    public void deleteCod(int id) {
        String sql = "DELETE FROM codes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea codului: " + e.getMessage());
        }
    }

    public void updatevalabilitateCod(int id) {
        String sql = "UPDATE codes SET valabilitate = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "invalid");
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la modificarea valabilitatii codului: " + e.getMessage());
        }
    }
}
