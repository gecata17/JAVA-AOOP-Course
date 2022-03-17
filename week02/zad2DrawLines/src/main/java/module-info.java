module com.example.zad2drawlines {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zad2drawlines to javafx.fxml;
    exports com.example.zad2drawlines;
}