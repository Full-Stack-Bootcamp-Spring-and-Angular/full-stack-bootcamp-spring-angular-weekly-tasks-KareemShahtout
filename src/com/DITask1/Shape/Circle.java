package com.DITask1.Shape;

import com.DITask1.Draw.Draw;

public class Circle extends Shape {

    public Circle(Draw draw) {
        this.drawBehavior = draw;
    }


    public void draw() {
        getShapeName();
        performDraw();
    }

    @Override
    public String getShapeName() {
        return "Circle ";
    }
}
