package com.ditask2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car c = (Car) container.getBean("carBean");
        c.saveData();
        Plane p = (Plane) container.getBean("planeBean");
        p.saveData();
    }
}
