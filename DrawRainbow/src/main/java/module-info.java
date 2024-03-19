module com.example.drawrainbow {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.drawrainbow to javafx.fxml;
    exports com.example.drawrainbow;
}