package com.example.drawlines;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class DrawLinesController {

    @FXML
    private Canvas canvas; // used to get the GraphicsContext

    @FXML
    void drawXButtonPressed(ActionEvent event){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeLine(0,0,canvas.getWidth(), canvas.getHeight());
        gc.strokeLine(canvas.getWidth(), 0, 0, canvas.getHeight());
    }

    @FXML
    void drawLinesButtonPressed(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();


        // Clear the canvas before drawing new lines
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Determine the number of lines to draw from each corner
        int linesCount = 10; // Adjust this value for more or fewer lines

        // Calculate the spacing between lines at the edges of the canvas
        double xIncrement = canvas.getWidth() / linesCount;
        double yIncrement = canvas.getHeight() / linesCount;

        // Draw lines fanning out from the corners
        for (int i = 0; i <= linesCount; i++) {
            // Lines from top-left corner fanning out to the bottom-right edge
            gc.strokeLine(0, yIncrement * i, xIncrement * i, canvas.getHeight());
            // Lines from top-right corner fanning out to the bottom-left edge
            gc.strokeLine(canvas.getWidth(), yIncrement * i, canvas.getWidth() - (xIncrement * i), canvas.getHeight());
            // Lines from bottom-left corner fanning out to the top-right edge
            gc.strokeLine(xIncrement * i, 0, 0, canvas.getHeight() - (yIncrement * i));
            // Lines from bottom-right corner fanning out to the top-left edge
            gc.strokeLine(canvas.getWidth() - (xIncrement * i), 0, canvas.getWidth(), canvas.getHeight() - (yIncrement * i));
        }
    }
}