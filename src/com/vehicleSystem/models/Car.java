package com.vehicleSystem.models;

import org.springframework.stereotype.Component;


@Component
public class Car extends Vehicle {
    public Car() {
        super(VehicleType.CAR);
    }
}
