module com.example.problem1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.problem1 to javafx.fxml;
    exports com.example.problem1;
}