module com.example.dialogboxesfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dialogboxesfx to javafx.fxml;
    exports com.example.dialogboxesfx;
}