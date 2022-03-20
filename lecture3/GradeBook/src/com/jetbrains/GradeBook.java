package com.jetbrains;

import java.util.Scanner;

public class GradeBook {
    public String courseName;
    private int total;
    private int gradeCounter;
    private int aCount;
    private int bCount;
    private int cCount;
    private int dCount;
    private int fCount;

    //constructor initializes courseName;
    public GradeBook(String name) {
        courseName = name;
    }

    public void setCourseName(String name) {
        courseName = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayMessage() {
        //getCourseName returns the value of courseName
        System.out.printf("Welcome to the grade book for \n%s!\n\n ", getCourseName());
    }

    public void inputGrades() {
        Scanner input = new Scanner(System.in);
        int grade;
        System.out.printf("%s\n%s\n %s\n %s\n",
                "Enter the integer grades in the range 0-100.",
                "Type the end-of-file indicator to terminate input:",
                "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
                "On Windows type <ctrl> z then press Enter");
        //loop condition uses method hasNext to determine wheather there is more data to input
        while (input.hasNext()) {
            grade = input.nextInt();
            total += grade;
            ++gradeCounter;
            //call method to increment appropriate counter
            incrementLetterGradeCounter(grade);
        }
    }

    public void incrementLetterGradeCounter(int numericGrade) {

        switch (numericGrade / 10) {
            case 9: // grade was between 90
            case 10: // and 100
                ++aCount; // increment aCount
                break; // necessary to exit switch
            case 8: // grade was between 80 and 89
                ++bCount; // increment bCount
                break; // exit switch


            case 7: // grade was between 70 and 79
                ++cCount; // increment cCount
                break; // exit switch

            case 6: // grade was between 60 and 69
                ++dCount; // increment dCount
                break; // exit switch
            default: // grade was less than 60
                ++fCount; // increment fCount
                break; // optional; will exit switch anyw
        }
    }

    public void displayGradeReport() {
        System.out.printf("\nGrade Report :");
        //if user entered at least one grade
        if (gradeCounter != 0) {
            //average of all grades
            double average = (double) total / gradeCounter;

            // output summary of results
            System.out.printf("Total of the %d grades entered is %d\n",
                    gradeCounter, total);
            System.out.printf("Class average is %.2f\n", average);
            System.out.printf("%s\n%s%d\n%s%d\n%s%d\n%s%d\n%s%d\n",
                    "Number of students who received each grade:",
                    "A: ", aCount, // display number of A grades
                    "B: ", bCount, // display number of B grades
                    "C: ", cCount, // display number of C grades
                    "D: ", dCount, // display number of D grades
                    "F: ", fCount); // display number of F grades
        } // end if
        else // no grades were entered, so output appropriate message
            System.out.println("No grades were entered");
    }


}
