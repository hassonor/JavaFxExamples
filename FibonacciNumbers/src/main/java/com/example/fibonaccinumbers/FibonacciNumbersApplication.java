package com.example.fibonaccinumbers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FibonacciNumbersApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FibonacciNumbersApplication.class.getResource("FibonacciNumbers.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("FibonacciNumbers");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}