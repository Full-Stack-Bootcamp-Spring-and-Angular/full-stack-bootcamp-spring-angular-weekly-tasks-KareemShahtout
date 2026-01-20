package main.com.userapp.dao;

import main.com.userapp.models.UserData;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;


@Component
//@Scope("singleton")
public class Database {
    private final String url = "jdbc:mysql://localhost:3306/user_db";

    private final String userName = "root";

    private final String password = "k_1234567";

    private Connection connection;

    @PostConstruct
    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection successful. Ready for use.");
        } catch (SQLException sqle) {
            throw new RuntimeException("Database connection failed", sqle);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() {
        if (connection == null) {
            throw new RuntimeException("Database connection is not initialized");
        }
        return connection;
    }

    public boolean insertVehicle(UserData userData) {
        boolean done = false;
        String sql = "INSERT INTO users(ln, fn ,email,city,birth_date) VALUES (?, ?, ?, ?, ?)";


        try (PreparedStatement statement = getConnection().prepareStatement(sql);) {
            statement.setString(1, userData.getFirstname());
            statement.setString(2, userData.getLastname());
            statement.setString(3, userData.getEmail());
            statement.setString(4, userData.getCity());
            statement.setDate(5, (Date) userData.getDateOfBirth());
            done = statement.execute();
        } catch (SQLException sqlException) {

        }

        return done;

    }


}
