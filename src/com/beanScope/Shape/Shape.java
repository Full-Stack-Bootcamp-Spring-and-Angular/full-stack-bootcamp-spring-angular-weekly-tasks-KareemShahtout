package com.beanScope.Shape;

import com.beanScope.Draw.Draw;

public abstract class Shape {
    Draw draw;


    Shape() {
    }


    Shape(Draw draw) {
        this.draw = draw;
    }

    public void setDrawStrategy(Draw draw) {
        this.draw = draw;
    }

    public void draw() {
        draw.draw(this);
    }


    public String getShapeName() {
        return this.getClass().getSimpleName();
    }
}
