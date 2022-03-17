module com.example.problem2drawing {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.problem2drawing to javafx.fxml;
    exports com.example.problem2drawing;
}