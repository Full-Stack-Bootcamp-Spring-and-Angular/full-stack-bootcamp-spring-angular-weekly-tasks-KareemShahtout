package com.vehicleSystem.controller;

import com.vehicleSystem.dao.DatabaseOperations;
import com.vehicleSystem.models.Vehicle;
import com.vehicleSystem.models.VehicleType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VehicleController {


    public boolean add(Vehicle vehicle);

    public Vehicle getVehicleById(int id);

    public List<Vehicle> getAllVehicles();

    public int update(Vehicle vehicle);

    public int remove(int id);

}
