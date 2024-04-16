module com.example.coverviewer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coverviewer to javafx.fxml;
    exports com.example.coverviewer;
}