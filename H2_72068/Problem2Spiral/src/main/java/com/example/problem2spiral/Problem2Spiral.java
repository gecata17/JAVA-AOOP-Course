package com.example.problem2spiral;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.paint.Color;

public class Problem2Spiral extends Application {

    @Override

    public void start(Stage stage)  {
        Group myGroup = new Group();//create a Group object
        Scene myScene = new Scene(myGroup, 600, 600);//create a Scene object with size values

        double width = myScene.getWidth() / 2;//retrieve the half of the whole width
        double height = myScene.getHeight() / 2;//retrieve the half of the whole height


        //create Line object in order to  draw 5 lines for the spiral
        Line myLine;


        //for-loop to loop through the lines to make the spiral
        for (int i = 0; i < 5; i++) {
            int temp = i * 20;

            //variables for coordinates of the lines
            double startXLine = width + temp;
            double startYLine = height + temp;
            double endXLine = width + temp;
            double endYLine = height + 20 + temp;

            //draw first Line and colour it
            myLine = new Line(startXLine, startYLine, endXLine, endYLine);
            myLine.setStroke(Color.RED);
            myGroup.getChildren().add(myLine);

            //values used for coordinates of second Line

            startXLine = width + temp;
            startYLine = height + 20 + temp;
            endXLine = width - 20 - temp;
            endYLine = height + 20 + temp;

            //draw second Line and colour it
            myLine = new Line(startXLine, startYLine, endXLine, endYLine);
            myLine.setStroke(Color.RED);
            myGroup.getChildren().add(myLine);

            //values used for coordinates of third Line
            startXLine = width - 20 - temp;
            startYLine = height + 20 + temp;
            endXLine = width - 20 - temp;
            endYLine = height - 20 - temp;

            //draw third Line and colour it
            myLine = new Line(startXLine, startYLine, endXLine, endYLine);
            myLine.setStroke(Color.RED);
            myGroup.getChildren().add(myLine);


            //values used for coordinates of fourth Line
            startXLine = width - 20 - temp;
            startYLine = height - 20 - temp;
            endXLine = width + 20 + temp;
            endYLine = height - 20 - temp;

            //draw fourth Line and colour it
            myLine = new Line(startXLine, startYLine, endXLine, endYLine);
            myLine.setStroke(Color.RED);
            myGroup.getChildren().add(myLine);


            //values used for coordinates of fifth Line
            startXLine = width + 20 + temp;
            startYLine = height - 20 - temp;
            endXLine = width + 20 + temp;
            endYLine = height + 20 + temp;


            //draw fifth Line and colour it
            myLine = new Line(startXLine, startYLine, endXLine, endYLine);
            myLine.setStroke(Color.RED);
            myGroup.getChildren().add(myLine);

        }//end for-loop

        // Set the title of the Stage(the application window)
        stage.setTitle("Drawing square shaped spiral of Georgi Birdanov");
        //set the scene of the Stage
        stage.setScene(myScene);
        //show the stage
        stage.show();

    }//end start


    //main method
    public static void main(String[] args) {

        launch();
    }//end main method

}//end class Problem2Spiral