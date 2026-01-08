package com.ditask1;

import com.ditask1.shape.Circle;
import com.ditask1.shape.Square;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");

        Circle c = (Circle) container.getBean("circleBean");
        c.draw();

        Square s = (Square) container.getBean("squareBean");
        s.draw();
    }
}
