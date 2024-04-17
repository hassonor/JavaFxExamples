package com.example.pressbuttonsdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PressButtonsDemoApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PressButtonsDemoApp.class.getResource("PressButtonsDemo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Press The Button");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}