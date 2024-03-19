package com.example.drawrainbow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class DrawRainbowController {
    @FXML
    private Canvas canvas;

    // colors to use in the rainbow, starting from the innermost
    // The two white entries result in an empty arc in the center
    private final Color[] colors = {
            Color.WHITE, Color.WHITE, Color.VIOLET, Color.INDIGO, Color.BLUE,
            Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED};


    @FXML
    void drawRainbowButtonPressed(ActionEvent event){
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Clear the canvas first

        final int radiusIncrement = 25;
        final double centerX = canvas.getWidth() / 2;
        double startY = canvas.getHeight() - 10; // Start Y-coordinate for the bottom arc

        // Calculate the starting Y position for the first (outermost) arc to ensure all arcs fit
        startY -= (colors.length - 2) * radiusIncrement;

        for(int counter = colors.length; counter > 0; counter--){
            gc.setFill(colors[counter-1]);

            // Adjust the Y-coordinate for each arc to align their bases
            double currentY = startY + (colors.length - counter) * radiusIncrement;

            gc.fillArc(centerX - counter * radiusIncrement, currentY, counter * radiusIncrement * 2,
                    counter * radiusIncrement * 2, 0, 180, ArcType.OPEN);
        }
    }
}