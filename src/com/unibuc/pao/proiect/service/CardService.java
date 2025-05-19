package src.com.unibuc.pao.proiect.service;
import src.com.unibuc.pao.proiect.model.cardCredit;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class CardService {
    private final Connection connection;

    public CardService() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    public void adaugaCard(cardCredit card) {
        String sql = "INSERT INTO card(id, numar_card, tip_card, CVV) VALUES (?, ?, ?, ?)";
        try(PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, card.getId());
            stm.setString(2, card.getNumarCard());
            stm.setString(3, card.getTipCard());
            stm.setString(4, card.getCVV());

            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la adaugarea cardului: " + e.getMessage());
        }
    }

    public Set<cardCredit> getAllCards() {
        Set<cardCredit> carduri = new LinkedHashSet<>();
        String sql = "SELECT * FROM card";
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String numarCard = rs.getString("numar_card");
                String tipCard = rs.getString("tip_card");
                String cvv = rs.getString("CVV");

                carduri.add(new cardCredit(id, numarCard, tipCard, cvv));
            }

        } catch (SQLException e) {
            System.out.println("Eroare la citirea cardurilor: " + e.getMessage());
        }
        return carduri;
    }

    public void updateCard(int id, String numarNou, String tipNou, String cvvNou) {
        String sql = "UPDATE card SET numar_card = ?,  tip_card = ?, CVV = ? WHERE id =?";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, numarNou);
            stmt.setString(2, tipNou);
            stmt.setString(3, cvvNou);
            stmt.setInt(4, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la modificare cardului: " + e.getMessage());
        }
    }

    public void deleteCard(int id) {
        String sql = "DELETE FROM card WHERE id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la stergerea cardului: " + e.getMessage());
        }
    }
}
