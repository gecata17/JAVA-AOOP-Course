package com.jetbrains;

import java.text.NumberFormat;
import java.util.Random;



public class RandomNumberTest {

    public static void main(String[] args) {

       RandomNumber generateRandNumber = new RandomNumber();

        //Loop of  10000 times representing the probability of the method returning 1,2 and 3
        System.out.println("First loop of 10000 times representing the probability and the result number");
        for (int i = 0; i < 10000; i++) {
            int resultFirstLoop;
            resultFirstLoop = generateRandNumber.drawRandomNumber();
            System.out.println("Result number : " + resultFirstLoop);
        }

        //Loop of  60000 times representing the probability of the method returning 1,2 and 3
        System.out.println("First loop of 60000 times representing the probability and the result number");
        for (int j = 0; j < 60000; j++) {
            int resultSecondLoop;
            resultSecondLoop = generateRandNumber.drawRandomNumber();
            System.out.println("Result number : " + resultSecondLoop);
        }
    }



}
