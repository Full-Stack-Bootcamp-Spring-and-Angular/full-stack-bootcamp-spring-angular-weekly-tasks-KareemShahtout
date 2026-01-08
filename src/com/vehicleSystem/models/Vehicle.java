package com.vehicleSystem.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@Setter
@Getter
public abstract class Vehicle {
    private int id;
    private String model;
    private final VehicleType type;


    protected Vehicle(VehicleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", type=" + type +
                '}';
    }
}
