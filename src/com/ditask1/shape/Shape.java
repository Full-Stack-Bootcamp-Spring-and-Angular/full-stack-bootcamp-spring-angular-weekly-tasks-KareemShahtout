package com.ditask1.shape;

import com.ditask1.draw.Draw;

abstract class Shape {
    protected Draw drawBehavior;

    protected void performDraw() {
        System.out.print(getShapeName());
        drawBehavior.draw();
    }

    abstract String getShapeName();
}
