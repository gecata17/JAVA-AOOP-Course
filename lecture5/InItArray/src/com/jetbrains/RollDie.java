package com.jetbrains;

import java.util.Random;

public class RollDie {
    public static void main(String[] args) {
        Random randomNumbers = new Random();//random number generator
        int [] frequency = new int[7];//array of frequency counters

        //roll die 6000 times; use die value as frequency index
        for (int roll = 1; roll <= 6000; roll++) {
            ++frequency[1+randomNumbers.nextInt(6)];

        }
        System.out.printf("%s%10s\n" , "Faces: ","Frequency :");

        for (int faces = 1; faces < frequency.length; faces++) {
            System.out.printf("%4d%10d\n",faces,frequency[faces]);
        }
    }
}
