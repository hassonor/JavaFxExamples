package com.example.textfieldsdemo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextFieldsController {

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    public void initialize(){
        textField1.textProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                        textField2.setText(newValue);
                    }
                }
        );
    }

}