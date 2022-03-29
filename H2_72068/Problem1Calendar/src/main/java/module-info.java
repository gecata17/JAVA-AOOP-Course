module com.example.problem1calendar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.problem1calendar to javafx.fxml;
    exports com.example.problem1calendar;
}