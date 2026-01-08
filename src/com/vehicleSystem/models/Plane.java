package com.vehicleSystem.models;

import org.springframework.stereotype.Component;


@Component
public class Plane extends Vehicle {
    public Plane() {
        super(VehicleType.PLANE);
    }
}

