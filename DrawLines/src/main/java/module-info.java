module com.example.drawlines {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.drawlines to javafx.fxml;
    exports com.example.drawlines;
}