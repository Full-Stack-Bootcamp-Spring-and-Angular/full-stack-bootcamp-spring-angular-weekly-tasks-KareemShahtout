package com.beanScope.Draw;

import com.beanScope.Shape.Shape;

public class Draw3d implements Draw {
    public void draw(Shape shape) {
        System.out.println(String.format("Drawing %s in 3D", shape.getShapeName()));
    }
}
