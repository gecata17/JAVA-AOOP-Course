package com.jetbrains;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int array[];//declare array named array

        array = new int[10];
        System.out.printf("%s%8s\n","Index","value");//columns headings

        //output each array ' s value

        for (int counter = 0; counter < array.length; counter++) {
            System.out.printf("%5d%8d\n",counter,array[counter]);
        }

        //second way
        //int array[] = {32,27,64,18,95,14,90,70,60,37};

        //third way
        //final int ARRAY_LENGTH=10;
        //INT array[] = new int[ARRAY_LENGTH];

    }
}
