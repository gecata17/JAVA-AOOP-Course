package com.example.problem1cgeometrytest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

import com.example.geometry.*;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();

        Scene scene = new Scene(group, 300, 250);

        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            double x = random.nextInt(101);
            double y = random.nextInt(101);
            double width = 1 + random.nextInt(200);
            double height = 1 + random.nextInt(200);
            Rectangle rectangle = new Rectangle(new Point(new double[]{x,y}),width,height);
            rectangle.draw(group);
            drawDiagonalLinesForRectangle(rectangle,group);
        }
        stage.setTitle("Geometry");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    private void drawDiagonalLinesForRectangle(Rectangle rectangle,Group group){
        double upperLeftX=rectangle.getUPoint().getCoordinates()[0];
        double upperLeftY=rectangle.getUPoint().getCoordinates()[1];
        Point uperLeftPoint = rectangle.getUPoint();
        Point lowerLeftPoint = new Point(new double[]{upperLeftX,upperLeftY+rectangle.getHeight()});
        Point upperRightPoint = new Point(new double[]{upperLeftX+ rectangle.getWidth(),upperLeftY});
        Point lowerRightPoint = new Point(new double[]{upperLeftX+ rectangle.getWidth(),upperLeftY
                + rectangle.getHeight()});
        Line firstDiagonal = new Line(uperLeftPoint,lowerRightPoint);
        Line secondDiagonal = new Line(upperRightPoint,lowerLeftPoint);
        firstDiagonal.draw(group);
        secondDiagonal.draw(group);



    }
}