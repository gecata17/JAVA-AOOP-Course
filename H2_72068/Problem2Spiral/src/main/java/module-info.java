module com.example.problem2spiral {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.problem2spiral to javafx.fxml;
    exports com.example.problem2spiral;
}