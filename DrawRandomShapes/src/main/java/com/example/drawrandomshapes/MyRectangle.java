package com.example.drawrandomshapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRectangle extends Shape {
    private double x;
    private double y;
    private double width;
    private double height;

    private Color strokeColor;

    public MyRectangle(double x, double y, double width, double height, Color strokeColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.strokeColor = strokeColor;
    }

    // Draw the rectangle in the specified color
    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(strokeColor);
        gc.strokeRect(x, y, width, height);
    }
}
