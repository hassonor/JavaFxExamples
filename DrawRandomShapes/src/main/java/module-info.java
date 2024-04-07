module com.example.drawrandomlines {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.drawrandomshapes to javafx.fxml;
    exports com.example.drawrandomshapes;
}