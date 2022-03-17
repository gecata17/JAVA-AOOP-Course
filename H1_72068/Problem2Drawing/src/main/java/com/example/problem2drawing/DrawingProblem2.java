package com.example.problem2drawing;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.io.IOException;


public class DrawingProblem2 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group myGroup = new Group();//create a Group object

        Scene scene = new Scene(myGroup, 400, 400);//create a scene

        double width = scene.getWidth();//total width
        double height = scene.getHeight();//total height


        //up left corner
        int counter = 1;//counter for the first while loop
        Line myLineLeftUp;  //line for the up left corner


        double startXLeftUp = 0;
        double startYLeftUp = height;
        double endXLeftUp = width / 15;
        double endYLeftUp = 0;

        while (counter <= 15) {
            myLineLeftUp = new Line(startXLeftUp, startYLeftUp, endXLeftUp, endYLeftUp);
            myLineLeftUp.setStroke(Color.ORANGE.darker());//set the colour of line
            myGroup.getChildren().add(myLineLeftUp);//add line to the group
            startYLeftUp -= height / 15;
            endXLeftUp += width / 15;
            counter++;
        }

        //down right corner

        int counter2 = 1;//counter for the second while loop
        Line myLineRightDown;//line for the down right corner
        double startXRightDown = width;
        double startYRightDown = 0;
        double endXRightDown = width - width / 15;
        double endYRightDown = height;
        //while loop
        while (counter2 <= 15) {
            myLineRightDown = new Line(startXRightDown, startYRightDown, endXRightDown, endYRightDown);
            myLineRightDown.setStroke(Color.ORANGE.darker());//set the colour of line
            myGroup.getChildren().add(myLineRightDown);//add line
            startYRightDown += height / 15;
            endXRightDown -= width / 15;
            counter2++;
        }//end while loop

        //down left corner
        int counter3 = 1;//counter for the third while loop
        Line myLineLeftDown;//line for the down left corner
        double startXLeftDown = 0;
        double startYLeftDown = 0;
        double endXLeftDown = width / 15;
        double endYLeftDown = height;
        //while loop
        while (counter3 <= 15) {
            myLineLeftDown = new Line(startXLeftDown, startYLeftDown, endXLeftDown, endYLeftDown);
            myLineLeftDown.setStroke(Color.ORANGE.darker());//set the colour of the line
            myGroup.getChildren().add(myLineLeftDown);//add line
            startYLeftDown += height / 15;
            endXLeftDown += width / 15;
            counter3++;
        }//end while loop

        //up right corner
        int counter4 = 1;//counter for the fourth while loop
        Line myLineRightUp;//line for the up right corner
        double startXRightUp = width;
        double startYRightUp = height;
        double endXRightUp = width - width / 15;
        double endYRightUp = 0;
        //while loop
        while (counter4 <= 15) {
            myLineRightUp = new Line(startXRightUp, startYRightUp, endXRightUp, endYRightUp);
            myLineRightUp.setStroke(Color.ORANGE.darker());//set the colour of the line
            myGroup.getChildren().add(myLineRightUp);//add line
            startYRightUp -= height / 15;
            endXRightUp -= width / 15;
            counter4++;
        }//end while loop

        // Set the title of the Stage(the application window)
        stage.setTitle("Drawing of Georgi Birdanov");
        //set the scene of the Stage
        stage.setScene(scene);
        //show the stage
        stage.show();
    }//end start

    public static void main(String[] args) {
        launch();
    }//end main

}//end class DrawingProblem2