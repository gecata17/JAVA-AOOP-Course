module com.example.problem1registration {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.problem1registration to javafx.fxml;
    exports com.example.problem1registration;
}