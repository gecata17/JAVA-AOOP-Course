module com.example.problem1a1bgeometry {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.geometry to javafx.fxml;
    exports com.example.geometry;
}