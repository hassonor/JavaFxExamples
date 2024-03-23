package com.example.drawshapes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

public class DrawShapesController {
    @FXML
    private Canvas canvas;

    @FXML
    void strockeRectanglesButtonPressed(ActionEvent event) {
        draw("rectangles");
    }

    @FXML
    void strockeOvalsButtonPressed(ActionEvent event) {
        draw("ovals");
    }

    @FXML
    void strockeOvalButtonPressed(ActionEvent event) {

    }

    @FXML
    void rectslButtonPressed(ActionEvent event) {
        draw_simple("rectangles");
    }

    @FXML
    void ovalsButtonPressed(ActionEvent event) {
        draw_simple("ovals");
    }

    @FXML
    void strokeCombinedShapesButtonPressed(ActionEvent event) {
        drawCombined();
    }

    public void drawCombined() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int step = 10;
        int count = 10; // Adjust the count as needed
        double width = canvas.getWidth() - 20; // Initial width and height, leaving some margin
        double height = canvas.getHeight() - 20;
        double x = 10; // Starting x and y positions for rectangles
        double y = 10;

        // For ovals, starting with the outermost
        double ovalX = x;
        double ovalY = y;
        double ovalWidth = width;
        double ovalHeight = height;

        for (int i = 0; i < count; i++) {
            // Draw rectangle
            gc.strokeRect(x, y, width, height);
            x += step; // Move start point for next rectangle inwards
            y += step; // Move start point for next rectangle inwards
            width -= 2 * step; // Decrease size for next rectangle
            height -= 2 * step; // Decrease size for next rectangle

            // Draw oval inside the rectangle
            gc.strokeOval(ovalX, ovalY, ovalWidth, ovalHeight);
            ovalX += step; // Adjust starting point for next oval
            ovalY += step; // Adjust starting point for next oval
            ovalWidth -= 2 * step; // Adjust width for the next oval
            ovalHeight -= 2 * step; // Adjust height for the next oval
        }
    }

    public void draw_simple(String shape) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int step = 10;
        for (int i = 0; i < 10; i++) {
            switch (shape) {
                case "rectangles":
                    gc.strokeRect(10 + i * step, 10 + i * step, 90 + i * step, 90 + i * step);
                    break;
                case "ovals":
                    gc.strokeOval(10 + i * step, 10 + i * step, 90 + i * step, 90 + i * step);
                    break;
            }
        }
    }

    public void draw(String choice) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int radiusIncrement = 10;
        int radius = 10;

        int step = 10;

        switch (choice) {
            case "rectangles":
                for (int i = 0; i < 10; i++) {
                    gc.strokeRect(10 + i * radiusIncrement, 10 + i * radiusIncrement, 90 + i * radiusIncrement, 90 + i * radiusIncrement);
                }
                break;
            case "ovals": // Handle drawing of circles here
                for (int i = 0; i < 12; i++) { // Changed loop to draw 12 circles
                    // Calculate the center based on the current radius to ensure circles are concentric
                    double centerX = canvas.getWidth() / 2;
                    double centerY = canvas.getHeight() / 2;
                    // Calculate the left upper corner of the bounding rectangle for the circle
                    double x = centerX - radius - (i * radiusIncrement);
                    double y = centerY - radius - (i * radiusIncrement);
                    double diameter = 2 * (radius + (i * radiusIncrement));
                    gc.strokeOval(x, y, diameter, diameter);
                }
                break;
            default:
                break;
        }
    }
}
