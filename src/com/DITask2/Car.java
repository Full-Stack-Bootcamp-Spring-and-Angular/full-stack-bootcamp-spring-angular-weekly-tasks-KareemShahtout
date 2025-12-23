package com.DITask2;

public class Car implements Vehicle {
    private DatabaseOperations databaseOperations;

    public Car(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    @Override
    public void saveData() {
        databaseOperations.storeVehicleData();
    }

}
