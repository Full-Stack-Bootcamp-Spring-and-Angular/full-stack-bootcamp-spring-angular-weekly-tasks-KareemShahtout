package com.DITask1.Shape;

import com.DITask1.Draw.Draw;

abstract class Shape {
    protected Draw drawBehavior;

    protected void performDraw() {
        System.out.print(getShapeName());
        drawBehavior.draw();
    }

    abstract String getShapeName();
}
