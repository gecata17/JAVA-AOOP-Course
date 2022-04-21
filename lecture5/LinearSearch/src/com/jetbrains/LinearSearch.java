package com.jetbrains;

import java.util.Random;

public class LinearSearch {

    private int[] data;
    private static Random generator = new Random();

    public LinearSearch(int size) {
        data = new int[size]; // create space for array

        // fill array with random ints in range 10-99
        for (int i = 0; i < size; i++)
            data[i] = 10 + generator.nextInt(90);
    } // end LinearArray constructor

    // perform a linear search on the data
    public int linearSearch(int searchKey) {
        // loop through array sequentially
        for (int index = 0; index < data.length; index++)
            if (data[index] == searchKey)
                return index; // return index of integer

        return -1; // integer was not found
    } // end method linearSearch

    // method to output values in array
    public String toString() {
        String temporary = " ";

        // iterate through array
        for (int element : data)
            temporary += element + " ";

        temporary += "\n"; // add end line character
        return temporary;
    }
}
