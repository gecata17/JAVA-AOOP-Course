module com.example.problem1cgeometrytest {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.example.problem1a1bgeometry;


    opens com.example.problem1cgeometrytest to javafx.fxml;
    exports com.example.problem1cgeometrytest;
}