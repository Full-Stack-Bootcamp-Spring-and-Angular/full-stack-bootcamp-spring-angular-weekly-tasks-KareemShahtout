package com.ditask1.shape;

import com.ditask1.draw.Draw;

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
