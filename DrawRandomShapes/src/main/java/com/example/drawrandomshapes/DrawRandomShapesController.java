package com.example.drawrandomshapes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.security.SecureRandom;
import java.util.ArrayList;

public class DrawRandomShapesController {
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static ArrayList<Shape> shapes = new ArrayList<>();
    @FXML
    private Canvas canvas;
    @FXML
    private Label lineCountLabel;

    @FXML
    void clearCanvasButtonPressed(ActionEvent event) {
        shapes.clear();
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        lineCountLabel.setText("Shapes: 0");
    }

    @FXML
    void drawLinesButtonPressed(ActionEvent event) {
        double[] coords = getRandomCoords(4);
        addShape(new MyLine(coords[0], coords[1], coords[2], coords[3], getRandomColor()));
    }

    @FXML
    void drawOvalsButtonPressed(ActionEvent event) {
        double[] coords = getRandomCoords(2); // Use only two for x, y and calculate width, height differently if needed
        double[] dimensions = getRandomDimensions();
        addShape(new MyOval(coords[0], coords[1], dimensions[0], dimensions[1], getRandomColor()));
    }

    @FXML
    void drawRectanglesButtonPressed(ActionEvent event) {
        double[] coords = getRandomCoords(2);
        double[] dimensions = getRandomDimensions();
        addShape(new MyRectangle(coords[0], coords[1], dimensions[0], dimensions[1], getRandomColor()));
    }

    private void addShape(Shape shape) {
        shapes.add(shape);
        drawLastShapeOnly();
        lineCountLabel.setText("Shapes: " + shapes.size());
    }

    private void drawLastShapeOnly() {
        if (!shapes.isEmpty()) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            Shape lastShape = shapes.get(shapes.size() - 1);
            lastShape.draw(gc);
        }
    }

    private Color getRandomColor() {
        return Color.rgb(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));
    }

    private double[] getRandomCoords(int count) {
        double[] coords = new double[count];
        for (int i = 0; i < count; i++) {
            coords[i] = randomNumbers.nextInt((int) canvas.getWidth());
        }
        return coords;
    }

    private double[] getRandomDimensions() {
        return new double[]{
                randomNumbers.nextInt((int) canvas.getWidth() / 2),
                randomNumbers.nextInt((int) canvas.getHeight() / 2)
        };
    }
}
