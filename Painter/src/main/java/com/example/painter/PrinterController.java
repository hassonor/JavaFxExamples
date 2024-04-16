package com.example.painter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PrinterController {
    // enum representing pen sizes
    private enum PenSize {
        SMALL(2),
        MEDIUM(4),

        LARGE(6);

        private final int radius;

        PenSize(int radius) {
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }
    }

    @FXML
    private RadioButton blackRadioButton;

    @FXML
    private RadioButton redRadioButton;

    @FXML
    private RadioButton greenRadioButton;

    @FXML
    private RadioButton blueRadioButton;

    @FXML
    private RadioButton smallRadioButton;

    @FXML
    private RadioButton mediumRadioButton;

    @FXML
    private RadioButton largeRadioButton;

    @FXML
    private ToggleGroup colorToggleGroup;

    @FXML
    private ToggleGroup sizeToggleGroup;

    @FXML
    private Pane drawingAreaPane;


    @FXML
    private Button undoButton;

    @FXML
    private Button clearButton;

    // instance variables for managing Painter state
    private PenSize radius = PenSize.MEDIUM; // radius for circle
    private Paint brushColor = Color.BLACK; // drawing color

    public void initialize() {
        // user data on a control can be any Object
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        greenRadioButton.setUserData(Color.GREEN);
        blueRadioButton.setUserData(Color.BLUE);
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
    }

    // handles drawingArea's onMouseDragged MouseEvent
    @FXML
    void drawingAreaMouseDragged(MouseEvent e) {
        Circle newCircle = new Circle(e.getX(), e.getY(), radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    // handles color RadioButton's ActionEvents
    @FXML
    void colorRadioButtonSelected(ActionEvent event) {
        // user data for each color RadioButton is the corresponding Color
        brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }

    // handles size RadioButton's ActionEvents
    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void undoButtonPressed(ActionEvent event) {
        int count = drawingAreaPane.getChildren().size();

        // if there are any shapes remove the last one added
        if (count > 0) {
            drawingAreaPane.getChildren().remove(count - 1);
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear(); // clear the canvas
    }

}
