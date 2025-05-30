package src.com.unibuc.pao.proiect.service;

import src.com.unibuc.pao.proiect.model.User;

import java.sql.*;

public class UserService {
    private static UserService instance;
    private final Connection connection;

    private UserService() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void createDatePersonale(User user) {
        String sql = "INSERT INTO utilizator VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getNume());
            stmt.setString(3, user.getPrenume());
            stmt.setInt(4, user.getVarsta());
            stmt.setString(5, user.getOras());
            stmt.setString(6, user.getStrada());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la crearea utilizatorului: " + e.getMessage());
        }
    }

    public User readDatePersonale() {
        String sql = "SELECT * FROM utilizator";
        User user = null;
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getInt("varsta"),
                        rs.getString("oras"),
                        rs.getString("strada")
                );
            }
        } catch (SQLException e) {
            System.out.println("Eroare la citirea utilizatorului: " + e.getMessage());
        }
        return user;
    }

    public void modificareDatePersonale(String nume, String prenume, int varsta, String oras, String strada) {
        String sql = "UPDATE utilizator SET nume = ?, prenume = ?, varsta = ?, oras = ?, strada = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nume);
            stmt.setString(2, prenume);
            stmt.setInt(3, varsta);
            stmt.setString(4, oras);
            stmt.setString(5, strada);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la modificarea utilizatorului: " + e.getMessage());
        }
    }

    public void stergereDatePersonale() {
        String sql = "DELETE FROM utilizator";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la ștergerea utilizatorului: " + e.getMessage());
        }
    }
}
