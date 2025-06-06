package src.com.unibuc.pao.proiect.service;

import src.com.unibuc.pao.proiect.model.Produs;
import src.com.unibuc.pao.proiect.model.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdusService {
    private static ProdusService instance;
    private final Connection connection;

    private ProdusService() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    public static ProdusService getInstance() {
        if (instance == null) {
            instance = new ProdusService();
        }
        return instance;
    }

    public void adaugaProdus(Produs produs) {
        String sql = "INSERT INTO produs(id, nume, pret, disponibilitate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, produs.getId());
            stm.setString(2, produs.getNume());
            stm.setDouble(3, produs.getPret());
            stm.setString(4, produs.getDisponibilitate());
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la adăugare produs: " + e.getMessage());
        }
    }

    public void adaugaInCos(Produs produs, Restaurant restaurant) {
        String sql = "INSERT INTO cos(id, nume, pret, disponibilitate, restaurant_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, produs.getId());
            stm.setString(2, produs.getNume());
            stm.setDouble(3, produs.getPret());
            stm.setString(4, produs.getDisponibilitate());
            stm.setInt(5, restaurant.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la adăugare produs în coș: " + e.getMessage());
        }
    }

    public List<Produs> readProduseCos() {
        List<Produs> produse = new ArrayList<>();
        String sql = "SELECT * FROM cos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                double pret = rs.getDouble("pret");
                String disponibilitate = rs.getString("disponibilitate");
                produse.add(new Produs(id, nume, pret, disponibilitate));
            }
        } catch (SQLException e) {
            System.out.println("Eroare la citirea produselor din coș: " + e.getMessage());
        }
        return produse;
    }

    public void updateProdusCos(Produs produs, int id) {
        String sql = "UPDATE cos SET nume = ?, pret = ?, disponibilitate = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produs.getNume());
            stmt.setDouble(2, produs.getPret());
            stmt.setString(3, produs.getDisponibilitate());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la actualizarea produsului din coș: " + e.getMessage());
        }
    }

    public void deleteProdusCos(int id) {
        String sql = "DELETE FROM cos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea produsului din coș: " + e.getMessage());
        }
    }

    public void deleteProduse() {
        String sql = "DELETE FROM cos";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea tuturor produselor din coș: " + e.getMessage());
        }
    }

    public int getRestaurantId(Produs produs) {
        int id = 0;
        String sql = "SELECT restaurant_id FROM cos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produs.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("restaurant_id");
                }
            }
        } catch (SQLException e) {
            System.out.println("Eroare la citirea restaurantului asociat produsului: " + e.getMessage());
        }
        return id;
    }
}
