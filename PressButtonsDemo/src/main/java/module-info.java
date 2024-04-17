module com.example.pressbuttonsdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pressbuttonsdemo to javafx.fxml;
    exports com.example.pressbuttonsdemo;
}