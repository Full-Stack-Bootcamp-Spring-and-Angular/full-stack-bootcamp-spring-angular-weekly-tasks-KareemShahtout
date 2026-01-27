package main.com.userapp.dao;

import main.com.userapp.model.UserModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;

@Component
public class Database {
    private final String url = "jdbc:mysql://localhost:3306/user_db";
    private final String user = "root";
    private final String password = "k_1234567";

    private Connection connection;

    @PostConstruct
    public void init() {
        try {
            // Initialize database connection here
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }

    private Connection getConnection() {
        if (connection == null) {
            throw new RuntimeException("Database connection is not initialized");
        }
        return connection;
    }

    public boolean insertUser(UserModel userModel) {
        String sql = "INSERT INTO users (fn, ln, email, city, birth_date,password) VALUES (?, ?, ?, ?, ?,?)";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, userModel.getFirstname());
            statement.setString(2, userModel.getLastname());
            statement.setString(3, userModel.getEmail());
            statement.setString(4, userModel.getCity());
            statement.setDate(5, Date.valueOf(userModel.getDate()));
            statement.setString(6, userModel.getPassword());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error inserting user: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
