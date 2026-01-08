package com.ditask2;

public class DatabaseOperations {
    private String url;
    private String username;
    private String password;

    public void storeVehicleData() {
        System.out.println(String.format("Storing vehicle data url= %s ,username= %s, password = %s in the database ", url, username, password));
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
