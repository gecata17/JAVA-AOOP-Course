package com.jetbrains;

public class GradeBook {

    public String courseName;
    private int grades[];

    public GradeBook(String courseName, int[] grades) {
        this.courseName = courseName;//initialize courseName
        this.grades = grades;// initialize grades
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;//store the course name

    }

    //method to retrieve the course name
    public String getCourseName() {
        return courseName;
    }

    public void displayMessage(){
        System.out.printf("Welocme to the grade book for \n%s1\n\n",getCourseName());

    }

    public void processGrades(){
        //output grades array

        outputGrades();

        System.out.printf("\nClass average is %.2f\n",getAverage());

        System.out.printf("Lowest grade is %d\nHighest grade is %d\n\n",getMininum(),getMaximum());

        //call outputBarChart to print grade distribution chart
        outputBarChart();

    }

    private void outputBarChart() {
    }

    private double getAverage() {
        int total=0;
        for(int grade :grades){
            total+=grade;
        }
        return (double) total/ grades.length;
    }

    private void outputGrades() {
        //output each student's grades
        for (int student = 0; student < grades.length; student++) {
            System.out.printf("Student : %.2d : %3d\n",student+1,grades[student]);

        }
    }


}
