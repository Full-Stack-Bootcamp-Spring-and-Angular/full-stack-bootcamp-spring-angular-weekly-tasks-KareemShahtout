package com.vehicleSystem.controller;

import com.vehicleSystem.dao.DatabaseOperations;
import com.vehicleSystem.models.Vehicle;
import com.vehicleSystem.models.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaneController implements VehicleController {

    private DatabaseOperations databaseOperations;


    @Override
    public Vehicle getVehicleById(int id) {
        return databaseOperations.findVehicleById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return databaseOperations.findVehiclesByType(VehicleType.PLANE);
    }

    @Override
    public boolean add(Vehicle vehicle) {
        return databaseOperations.insertVehicle(vehicle);
    }

    @Override
    public int update(Vehicle vehicle) {
        return databaseOperations.update(vehicle);
    }

    @Override
    public int remove(int id) {
        return databaseOperations.deleteById(id);
    }

    @Autowired
    private void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }
}
