package com.jetbrains;

public class SumArray {
    public static void main(String[] args) {
        int [] array={34,5,6,7,8,1,3,2,4,5};
        int total=0;

        for (int i = 0; i < array.length; i++) {
            total+=array[i];
        }
        System.out.printf("Total sum of elements:  %d\n",total);
    }

}
