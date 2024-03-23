module com.example.drawandfill {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.drawandfill to javafx.fxml;
    exports com.example.drawandfill;
}