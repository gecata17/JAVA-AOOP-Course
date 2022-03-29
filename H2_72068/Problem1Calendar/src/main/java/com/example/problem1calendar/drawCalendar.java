package com.example.problem1calendar;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;

public class drawCalendar extends Application {
    //method to retrieve the index of every day of the week
    public int getIndex(DayOfWeek date) {
        switch (date) {
            case MONDAY: {
                return 1;
            }
            case TUESDAY: {
                return 2;
            }
            case WEDNESDAY: {
                return 3;
            }
            case THURSDAY: {
                return 4;
            }
            case FRIDAY: {
                return 5;
            }
            case SATURDAY: {
                return 6;
            }
            case SUNDAY: {
                return 7;
            }
            default:
                return 0;
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group myGroup = new Group();//create a Group object
        Scene myScene = new Scene(myGroup, 400, 400);//create a Scene object with size values
        //set starting positions
        int startX = 90;
        int startY = 70;
        //input dialog textbox for year
        TextInputDialog userYear = new TextInputDialog();
        userYear.setHeaderText("Please, enter the year ");//set the header text of the TextInputDialog for year
        userYear.setTitle("Input Year");//set the title of the TextInputDialog for year
        userYear.setContentText("Year: ");//set the content text of the TextInputDialog for year

        //input dialog textbox for month
        TextInputDialog userMonth = new TextInputDialog();
        userMonth.setHeaderText("Please, enter the month :");//set the header text of the TextInputDialog for month
        userMonth.setTitle("Input Month");//set the title of the TextInputDialog for month
        userMonth.setContentText("Month: ");//set the content text of the TextInputDialog for month

        //get the user input and save it in another variable year and month
        Optional<String> result = userYear.showAndWait();
        double year = Double.parseDouble(result.get());
        Optional<String> result1 = userMonth.showAndWait();
        double month = Double.parseDouble(result1.get());

        //start to draw our calendar
        //1) header line (name of the week days)
        Text weekDays = new Text(80, 50, "MON  TUE  WED  THR  FRI  SAT  SUN");//abbreviations of the days of the week
        weekDays.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));//set the font of the letters
        weekDays.setStroke(Color.BLACK);//set the colour of the weekdays
        myGroup.getChildren().add(weekDays);//add the weekdays to the group

        //get the local time from the users input
        LocalDate date = LocalDate.of((int) year, (int) month, 1);
        int index = getIndex(date.getDayOfWeek());

        //saving in variable daysInMonth - how many days are there in the current month entered by the user
        YearMonth yearMonth = YearMonth.of((int) year, (int) month);
        int daysInMonth = yearMonth.lengthOfMonth();

        //saving today's day, month, year
        LocalDate today = LocalDate.now();
        int todayDay = today.getDayOfMonth();
        int todayMonth = today.getMonthValue();
        int todayYear = today.getYear();


        for (int i = 2 - index; i <= daysInMonth; i++) {

            for (int j = 0; j < 7; j++) {

                if (i > daysInMonth)
                    break;

                if (i >= 1) {
                    //print the days index in the calendar
                    Text dayIndex = new Text(startX, startY, String.format("%d", i));
                    //check if the entered month contains today's day, and if it contains - its red
                    if (i == todayDay && todayMonth == month && todayYear == year) {
                        dayIndex.setStroke(Color.RED);
                    }

                    myGroup.getChildren().add(dayIndex);//add the dayIndex to the group

                } else {
                    //printing needed spaces between day indexes
                    Text spaces = new Text(startX, startY, "  ");
                    myGroup.getChildren().add(spaces);
                }

                i++;
                startX += 35;  //changing the positions
            }
            i--;
            startX = 90;
            startY += 20;
        }

        // Set the title of the Stage(the application window)
        stage.setTitle("drawCalendar for " + yearMonth.getMonth() + " " + yearMonth.getYear());
        //set the scene of the Stage
        stage.setScene(myScene);
        //show the stage
        stage.show();

    }//end start method

    public static void main(String[] args) {
        launch(args);
    }//end main method

}//end drawCalendar method