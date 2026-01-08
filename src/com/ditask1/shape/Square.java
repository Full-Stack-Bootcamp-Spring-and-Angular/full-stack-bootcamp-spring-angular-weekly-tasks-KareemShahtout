package com.DITask1.Shape;

import com.DITask1.Draw.Draw;

public class Square extends Shape {

    public void draw() {
        performDraw();
    }

    @Override
    public String getShapeName() {
        return "Square ";
    }
    public void setDrawBehavior(Draw draw) {
        this.drawBehavior = draw;
    }
}
