module com.example.drawrandomlines {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.drawrandomlines to javafx.fxml;
    exports com.example.drawrandomlines;
}