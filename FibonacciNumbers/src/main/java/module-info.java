module com.example.fibonaccinumbers {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fibonaccinumbers to javafx.fxml;
    exports com.example.fibonaccinumbers;
}