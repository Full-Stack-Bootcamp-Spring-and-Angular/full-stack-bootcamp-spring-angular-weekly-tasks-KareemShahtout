package com.vehicleSystem.view;

import com.vehicleSystem.config.ConfigClass;

import com.vehicleSystem.controller.BikeController;
import com.vehicleSystem.controller.CarController;
import com.vehicleSystem.controller.PlaneController;
import com.vehicleSystem.dao.DatabaseOperations;
import com.vehicleSystem.models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(ConfigClass.class);

        CarController carController = container.getBean(CarController.class);

        Car car1 = container.getBean(Car.class);
        car1.setId(100);
        car1.setModel("BMW");
        carController.add(car1);

        Car car2 = container.getBean(Car.class);
        car2.setId(101);
        car2.setModel("Mercedes");
        carController.add(car2);


        PlaneController planeController = container.getBean(PlaneController.class);

        Plane plane1 = container.getBean(Plane.class);
        plane1.setId(200);
        plane1.setModel("Embraer");
        planeController.add(plane1);


        Plane plane2 = container.getBean(Plane.class);
        plane2.setId(201);
        plane2.setModel("Boeing");
        planeController.add(plane2);


        BikeController bikeController = container.getBean(BikeController.class);
        Bike bike1 = container.getBean(Bike.class);
        bike1.setId(300);
        bike1.setModel("Yamaha");
        bikeController.add(bike1);

        Bike bike2 = container.getBean(Bike.class);
        bike2.setId(301);
        bike2.setModel("KTM");
        bikeController.add(bike2);


        plane2.setModel("Airhock");
        planeController.update(plane2);


        for (Vehicle v : planeController.getAllVehicles()) {
            System.out.println(v.toString());;
        }
        for (Vehicle v : carController.getAllVehicles()) {
            System.out.println(v.toString());;
        }
        for (Vehicle v : bikeController.getAllVehicles()) {
            System.out.println(v.toString());;
        }

        planeController.update(plane2);
        carController.remove(car1.getId());
        System.out.println("-------------------------------------------");

        for (Vehicle v : planeController.getAllVehicles()) {
            System.out.println(v.toString());;
        }
        for (Vehicle v : carController.getAllVehicles()) {
            System.out.println(v.toString());;
        }
        for (Vehicle v : bikeController.getAllVehicles()) {
            System.out.println(v.toString());;
        }


        container.close();
    }


}
