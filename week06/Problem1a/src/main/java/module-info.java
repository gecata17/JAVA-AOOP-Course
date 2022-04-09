module com.example.problem1a {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.problem1a to javafx.fxml;
    exports com.example.problem1a;
}