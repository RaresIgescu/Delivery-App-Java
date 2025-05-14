package src.com.unibuc.pao.proiect.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    public static Connection connection;

    String url = "jdbc:postgresql://localhost:5432/food_delivery";
    String user = "postgres";
    String password = "Rares_2004";

    private DBConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Eroare la conectare DB: " + e.getMessage());
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
