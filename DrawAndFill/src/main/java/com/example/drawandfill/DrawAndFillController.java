package com.example.drawandfill;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class DrawAndFillController {
    @FXML
    private Canvas canvas;

    @FXML
    void drawButton1(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        double red, green, blue;

        for (int i = 0; i < 25; i++) {
            red = Math.random();
            green = Math.random();
            blue = Math.random();

            gc.setFill(new Color(red, green, blue, 1));
            gc.fillRect(10 + i * 5, 20 + i * 5, 50 + i * 5, 50 + i * 5);
        }
    }

    @FXML
    void drawButton2(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int i = 0; i < 10; i++) {
            double red = Math.random();
            double green = Math.random();
            double blue = Math.random();
            gc.setFill(new Color(red, green, blue, 1));

            // Randomly decide whether to draw a rectangle or an oval
            boolean drawRectangle = Math.random() > 0.5;

            // Generate random position and size, limited to half the canvas dimensions
            double x = Math.random() * canvas.getWidth();
            double y = Math.random() * canvas.getHeight();
            double width = Math.random() * (canvas.getWidth() / 2);
            double height = Math.random() * (canvas.getHeight() / 2);

            if (drawRectangle) {
                gc.fillRect(x, y, width, height);
            } else {
                gc.fillOval(x, y, width, height);
            }
        }
    }
}