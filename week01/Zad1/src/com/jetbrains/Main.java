package com.jetbrains;

import java.util.Scanner;

public class Main {
    public static void toCelsius(double input) {
        double celsius = 5.0 / 9.0 * (input - 32);
        System.out.println("The temperature in Celsius is " + celsius);
    }

    public static void toFahrenheit(double input) {
        double fahrenheit = 9.0 / 5.0 * input + 32;
        System.out.println("The temperature in Fahrenheit is " + fahrenheit);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the temperature measurement C or F");
        String userInput = input.next();

        System.out.println("Please enter the temperature measurement in Celsius or Fahrenheit");
        double temperature = input.nextDouble();

        if (userInput.equals("C")) {
            toFahrenheit(temperature);
        } else if (userInput.equals("F")) {
            toCelsius(temperature);
        } else {
            System.out.println("Invalid temperature measurement");
        }
    }
}
