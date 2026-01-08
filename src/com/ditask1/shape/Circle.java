package com.ditask1.shape;

import com.ditask1.draw.Draw;

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
