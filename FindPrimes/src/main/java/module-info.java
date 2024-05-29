module com.example.findprimes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.findprimes to javafx.fxml;
    exports com.example.findprimes;
}