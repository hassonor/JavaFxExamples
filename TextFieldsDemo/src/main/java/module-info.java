module com.example.textfieldsdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.textfieldsdemo to javafx.fxml;
    exports com.example.textfieldsdemo;
}