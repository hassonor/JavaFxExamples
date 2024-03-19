module com.example.drawsmiley {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.drawsmiley to javafx.fxml;
    exports com.example.drawsmiley;
}