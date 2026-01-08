package com.vehicleSystem.controller;

import com.vehicleSystem.models.Vehicle;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VehicleController {


    boolean add(Vehicle vehicle);

    Vehicle getVehicleById(int id);

    List<Vehicle> getAllVehicles();

    public int update(Vehicle vehicle);

    public int remove(int id);

}
