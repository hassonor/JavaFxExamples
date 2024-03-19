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
    void strockeRectanglesButtonPressed(ActionEvent event){
        draw("rectangles");
    }

    @FXML
    void strockeOvalsButtonPressed(ActionEvent event){
        draw("ovals");
    }

    public void draw(String choice) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int radiusIncrement = 10;
        int radius = 10;

        int step = 10;

            switch (choice) {
                case "rectangles":
                    for(int i = 0; i < 10; i++){
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
