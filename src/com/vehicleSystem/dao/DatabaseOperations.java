package com.vehicleSystem.dao;


import com.vehicleSystem.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class DatabaseOperations {
    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String userName;

    @Value("${database.password}")
    private String password;

    private final String idColumn = "id";
    private final String modelColumn = "model";
    private final String typeColumn = "type";

    private Connection connection;

    public DatabaseOperations() {

    }

    @PostConstruct
    public void init() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection successful. Ready for use.");
        } catch (SQLException sqle) {
            throw new RuntimeException("Database connection failed", sqle);

        }
    }

    private Connection getConnection() {
        if (connection == null) {
            throw new RuntimeException("Database connection is not initialized");
        }
        return connection;
    }

    public List<Vehicle> findAllVehicles() {

        List<Vehicle> vehiclesSet = new ArrayList<>();

        String sqlStatement = "SELECT * FROM vehicle";

        try (Statement statement = getConnection().createStatement();
             ResultSet re = statement.executeQuery(sqlStatement)) {

            while (re.next()) {
                Vehicle vehicle = getVehicleType(re);
                vehiclesSet.add(vehicle);
            }

        } catch (SQLException sqlException) {
            exceptionMessage("Retrieve", sqlException.getMessage());

        }

        return vehiclesSet;
    }

    public boolean insertVehicle(Vehicle vehicle) {
        boolean done = false;
        String sql = String.format("INSERT INTO vehicle(%s, %s ,%s) VALUES (?, ?, ?)",
                idColumn,
                modelColumn,
                typeColumn);

        try (PreparedStatement statement = getConnection().prepareStatement(sql);) {
            statement.setInt(1, vehicle.getId());
            statement.setString(2, vehicle.getModel());
            statement.setString(3, vehicle.getType().toString());
            done = statement.execute();
        } catch (SQLException sqlException) {
            exceptionMessage("Add", sqlException.getMessage());
        }

        return done;

    }

    public Vehicle findVehicleById(int id) {
        String sql = String.format("SELECT %s ,%s , %s FROM vehicle WHERE %s = ?",
                idColumn,
                modelColumn,
                typeColumn,
                idColumn);

        Vehicle vehicle = null;

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet re = statement.executeQuery();
            if (re.next()) {
                vehicle = getVehicleType(re);
            }

        } catch (SQLException sqlException) {
            exceptionMessage("Retrieve", sqlException.getMessage());
        }
        return vehicle;
    }

    public List<Vehicle> findVehiclesByType(VehicleType type) {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = String.format("SELECT * FROM vehicle WHERE %s = ?",
                typeColumn);

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, type.toString());
            ResultSet re = statement.executeQuery();
            while (re.next()) {
                Vehicle vehicle = getVehicleType(re);
                vehicles.add(vehicle);
            }
        } catch (SQLException sqlException) {
            exceptionMessage("Retrieve", sqlException.getMessage());

        }

        return vehicles;
    }

    public int deleteById(int id) {
        String sql = String.format("DELETE FROM vehicle WHERE %s = ?", idColumn);
        int rowsAffected = 0;

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            rowsAffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
            exceptionMessage("Delete", sqlException.getMessage());
        }

        return rowsAffected;
    }

    public int update(Vehicle vehicle) {
        int rowsAffected = 0;
        String sql = String.format("UPDATE vehicle SET %s = ? WHERE %s = ?",
                modelColumn,
                idColumn);
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, vehicle.getModel());
            statement.setInt(2, vehicle.getId());
            rowsAffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
            exceptionMessage("Update", sqlException.getMessage());

        }
        return rowsAffected;
    }

    private Vehicle getVehicleType(ResultSet rs) throws SQLException {
        Vehicle vehicle;
        VehicleType type = VehicleType.valueOf(rs.getString(typeColumn));

        vehicle = switch (type) {
            case CAR -> new Car();
            case PLANE -> new Plane();
            case BIKE -> new Bike();
        };

        vehicle.setId(Integer.parseInt(rs.getString(idColumn)));
        vehicle.setModel(rs.getString(modelColumn));
        return vehicle;
    }

    private void exceptionMessage(String operationType, String mess) {
        System.out.println(String.format("%s operation failed!! [%s]",
                operationType, mess));
    }


    @PreDestroy
    public void destroy() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Disconnected from Database");
    }
}
