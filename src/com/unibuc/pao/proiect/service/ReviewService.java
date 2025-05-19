package src.com.unibuc.pao.proiect.service;
import src.com.unibuc.pao.proiect.model.Review;
import src.com.unibuc.pao.proiect.model.cardCredit;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ReviewService {
    private final Connection connection;

    public ReviewService() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    public void adaugaReview(Review review) {
        String sql = "INSERT INTO review VALUES (?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, review.getId());
            stmt.setDouble(2, review.getScore());
            stmt.setString(3, review.getComentariu());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la crearea review-ului: " + e.getMessage());
        }
    }

    public List<Review> readReviews() {
        List<Review> reviews = new LinkedList<>();
        String sql = "SELECT * FROM review";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                double scor = rs.getDouble("scor");
                String comentariu = rs.getString("comentariu");

                reviews.add(new Review(id, scor, comentariu));
            }
        } catch (SQLException e) {
            System.out.println("Eroare la citirea cardurilor: " + e.getMessage());
        }
        return reviews;
    }

    public void updateReview(int id, double scor, String comentariu) {
        String sql = "UPDATE review SET scor = ?, comentariu = ? WHERE id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, scor);
            stmt.setString(2, comentariu);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la modificarea review-ului: " + e.getMessage());
        }
    }
}
