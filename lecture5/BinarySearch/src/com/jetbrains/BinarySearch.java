package com.jetbrains;


import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    private int[] data;
    private static Random generator = new Random();

    public BinarySearch(int size) {
        data = new int[size];

        for (int index = 0; index < data.length; index++) {
            data[index] = 10 + generator.nextInt(90);

        }

        Arrays.sort(data);
    }

    public int binarySearch(int searchedKeys) {
        int low = 0;
        int high = data.length - 1;
        int middle = (high + low + 1) / 2;
        int location = -1;//return value; -1 if not found

        do {
            System.out.println(remainingElements(low, high));
            for (int i = 0; i < middle; i++) {
                System.out.print("  ");

            }
            System.out.println(" * ");//indicate current middle

            if (searchedKeys == data[middle]) {
                location = middle;
            } else if (searchedKeys < data[middle]) {
                high = middle - 1;//eliminate the higher half
            } else {
                low = middle + 1;//eliminate the lower half
            }
            middle = (low + high + 1) / 2;//recalculate the middle
        } while ((low <= high) && location == -1);

        return location;
    }

    //method to output certain values in array
    public String remainingElements(int low, int high) {
        String temp = " ";

        //output spaces for alignment
        for (int i = 0; i < low; i++) {
            temp += "  ";
        }

        //output elements left in array
        for (int i = low; i < high; i++) {
            temp += data[i] + " ";
        }
        temp += "\n";
        return temp;
    }

    public String toString(){
        return remainingElements(0,data.length-1);

    }
}
