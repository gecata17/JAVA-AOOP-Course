package com.jetbrains;

public class RecursiveSums {

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.printf("%-10d%.2f\n",i,computeSum(i));
            //System.out.println(computeSum(i));
        }
    }

    private static double computeSum(int i) {
        if (i < 0) {
            return 0;

        }

        return (i / ((2.0 * i) + 1) + computeSum(i - 1));
    }
}
