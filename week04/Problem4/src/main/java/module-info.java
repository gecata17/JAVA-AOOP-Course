module com.example.problem4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.problem4 to javafx.fxml;
    exports com.example.problem4;
}