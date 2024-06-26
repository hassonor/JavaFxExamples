package com.example.drawrandomshapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine extends Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    private Color strokeColor;

    public MyLine(
            double x1, double y1, double x2, double y2, Color strokeColor) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.strokeColor = strokeColor;
    }

    // draw the line in the specified color
    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(strokeColor);
        gc.strokeLine(x1, y1, x2, y2);
    }
}
