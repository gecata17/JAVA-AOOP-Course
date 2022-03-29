package com.jetbrains;

import java.lang.Math;
import java.text.NumberFormat;
import java.util.Random;

public class RandomNumber {
    public static int drawRandomNumber() {

        Random randomNumber = new Random();//create an instance of the Random class
        double generatedRandNumber = randomNumber.nextDouble(1, 100);//call the random value generator method for integers between 1 and 100
        NumberFormat formatPercentage = NumberFormat.getPercentInstance();//create an instance of the NumberFormat class in order to display probabilities as percentages
        //display the probability in the required percentage format
        System.out.println("Returned probability is : " + formatPercentage.format(generatedRandNumber / 100));
        if (generatedRandNumber >= 51 && generatedRandNumber <= 100) {//probability of number 3 (numbers between 51 and 100)
            return 3;
        } else if (generatedRandNumber >= 21 && generatedRandNumber <= 50) {//probability of number 2 (numbers between 21 and 50)
            return 2;
        } else { //probability of number 1 (numbers between 1 and 20)
            return 1;
        }

    }//end method drawRandomNumber

}//end class RandomNumber
