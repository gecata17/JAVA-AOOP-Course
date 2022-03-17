package com.jetbrains;

public class GradeBook {
    private String courseName;
    //constructor parameter
    public GradeBook(String name) {
        courseName = name;
    }

    //method to set the course name
    public void setCourseName(String name) {
        if (name != null) {
            courseName = name;
        } else {
            courseName = "No name";

        }
    }
        //method to retrieve the course name


    public String getCourseName() {
        return courseName;
    }

    //method to display a message to users
        public void displayMessage () {

            System.out.printf("Welcome to the grade book %n%s!%n", getCourseName());
        }

    }


