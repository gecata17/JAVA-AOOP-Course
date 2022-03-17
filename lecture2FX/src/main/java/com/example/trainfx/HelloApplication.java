package com.example.trainfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage)  {
        Group group = new Group();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(group, 320, 240);
        double width =scene.getWidth();
        double height = scene.getHeight();

        Line line = new Line(0,0,width,height);
        line.setStroke(Color.BLUE);
        line.setStrokeWidth(2);

        group.getChildren().add(line);
        line = new Line(0,height,width,0);
        line.setStroke(Color.BLUE);
        line.setStrokeWidth(2);
        group.getChildren().add(line);

        stage.setTitle("Drawing shapes ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}