module com.example.trainfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trainfx to javafx.fxml;
    exports com.example.trainfx;
}