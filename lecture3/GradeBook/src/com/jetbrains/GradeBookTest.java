package com.jetbrains;

public class GradeBookTest {
    public static void main(String[] args) {
        GradeBook myGradeBook = new GradeBook("Intro to JAVA Assessment Course");

        myGradeBook.displayMessage();
        myGradeBook.inputGrades();
        myGradeBook.displayGradeReport();

    }

}
