package com.example.pressbuttonsdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PressButtonsDemoController {

    @FXML
    private Button buttonNumber1;

    @FXML
    private Button buttonNumber2;

    @FXML
    private Button buttonNumber3;

    @FXML
    private TextField textField;

    @FXML
    void pressButtonNumber1(ActionEvent event) {
        textField.setText(buttonNumber1.getText());
    }

    @FXML
    void pressButtonNumber2(ActionEvent event) {
        textField.setText(buttonNumber2.getText());
    }

    @FXML
    void pressButtonNumber3(ActionEvent event) {
        textField.setText(buttonNumber3.getText());
    }

}
