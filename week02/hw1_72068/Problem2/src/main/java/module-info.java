module com.example.problem2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.problem2 to javafx.fxml;
    exports com.example.problem2;
}