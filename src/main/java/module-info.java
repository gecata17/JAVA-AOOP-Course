module com.example.lecture02fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lecture02fx to javafx.fxml;
    exports com.example.lecture02fx;
}