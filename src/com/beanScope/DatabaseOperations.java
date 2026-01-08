package com.beanScope;

public class DatabaseOperations {


    public void connectToDatabase() {
        System.out.println("connection to database established ……");
    }

    public DatabaseOperations() {
        System.out.println("DatabaseOperations instance created and ready to use.");
    }

    public void disconnectFromDatabase() {
        System.out.println("connection to database closed……");
    }
}
