package com.jetbrains;

import java.util.Scanner;

public class Hamming {

    private static int calculateHammingDistance(int firstNumber, int secondNumber) {
        int bits = 0;
        //exclusive OR (^) operator
        int value = firstNumber ^ secondNumber;

        while (value > 0) {
            // bits = bits + value & 1
            // & (AND) operator
            bits += value & 1;

            // signed right shift operator
            value >>= 1;
        }
        //finally, we return the distance
        return bits;
    }

    private static String toBinary(int number, int bits) {
        //print correctly binary numbers
        if (bits > 0) {
            return String.format("%" + bits + "s", Integer.toBinaryString(number)).replaceAll(" ", "0");
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int firstNumber, secondNumber;

        // if a number has 8 bits, this means in should fit in (0000 0000)
        // the largest number which can fit in 8 bits is 255, the smallest is

        do{
            System.out.println("Your number has to be in range [0.255]");
            System.out.print("Number A: ");
            firstNumber = input.nextInt();
        }while(firstNumber>255);


        do {
            System.out.println("Your number has to be in range [0.255]");
            System.out.print("Number B: ");
            secondNumber = input.nextInt();

        } while (secondNumber > 255);


        int distance = calculateHammingDistance(firstNumber, secondNumber);
        System.out.println("Result");
        System.out.println("----------------");
        System.out.println("The Hamming distance between numbers ");
        System.out.println(firstNumber + "(dec): "  + toBinary(firstNumber,8) + "(bin)");
        System.out.println(secondNumber + "(dec): " + toBinary(secondNumber,8) + "(bin)");
        System.out.println("is: " + distance);
    }
}
