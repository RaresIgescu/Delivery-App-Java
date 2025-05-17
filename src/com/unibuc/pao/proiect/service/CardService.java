package src.com.unibuc.pao.proiect.service;
import src.com.unibuc.pao.proiect.model.cardCredit;

import java.sql.*;

public class CardService {
    private final Connection connection;

    public CardService() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    public void adaugaCard(cardCredit card) {
        String sql = "INSERT INTO cardCredit(id, numarCard, tipCard, CVV) VALUES (?, ?, ?, ?)";
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
}
