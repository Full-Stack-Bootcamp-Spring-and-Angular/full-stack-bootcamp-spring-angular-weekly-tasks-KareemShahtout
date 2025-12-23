package com.DITask2;

public class Plane implements Vehicle{
    private DatabaseOperations databaseOperations;
    @Override
    public void saveData() {
        databaseOperations.storeVehicleData();
    }

    public void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }
}
