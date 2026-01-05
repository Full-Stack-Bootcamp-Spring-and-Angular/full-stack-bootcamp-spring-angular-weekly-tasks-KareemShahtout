package com.vehicleSystem.models;

import org.springframework.stereotype.Component;


@Component
public class Bike extends Vehicle {
    public Bike() {
        super(VehicleType.BIKE);
    }
}
