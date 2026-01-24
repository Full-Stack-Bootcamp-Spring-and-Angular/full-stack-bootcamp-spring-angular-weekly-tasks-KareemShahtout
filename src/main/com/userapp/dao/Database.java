package main.com.userapp.dao;

import main.com.userapp.model.UserData;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;

@Component
@Scope("singleton")
public class Database {
    private final String url = "jdbc:mysql://localhost:3306/user_db";
    private final String userName = "root";
    private final String password = "k_1234567";
    private Connection connection;

    // Database connection and methods would go here
    @PostConstruct
    public void init() {
        // Initialize database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection successful. Ready for use.");
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed", e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            throw new RuntimeException("Database connection is not initialized");
        }
        return connection;
    }

    public boolean submitUser(UserData userData) {
        String sql = "insert into users(fn, ln, email, city, birth_date) values (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(sql);) {
            statement.setString(1, userData.getFirstname());
            statement.setString(2, userData.getLastname());
            statement.setString(3, userData.getEmail());
            statement.setString(4, userData.getCity());
            if (userData.getDateOfBirth() != null) {
                statement.setDate(5, new java.sql.Date(userData.getDateOfBirth().getDate()));
            } else {
                statement.setNull(5, Types.DATE);

            }
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
