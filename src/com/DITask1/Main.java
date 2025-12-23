package com.DITask1;

import com.DITask1.Shape.Circle;
import com.DITask1.Shape.Square;
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
