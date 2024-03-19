module com.example.drawshapes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.drawshapes to javafx.fxml;
    exports com.example.drawshapes;
}