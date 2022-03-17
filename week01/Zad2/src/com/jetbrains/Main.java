package com.jetbrains;

import java.util.Scanner;

public class Main {
    static boolean isPalindrome(String str) {

        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        // Given string is a palindrome
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String userInput = input.next();
        int number;
        int digitFirst;
        int digitSecond;
        int digitThird;
        int digitFourth;
        int digitLast;
        if (userInput.length() == 5) {
            number = Integer.parseInt(userInput);
            digitFirst = number / 10000;
            digitSecond = (number / 1000) % 10;
            digitThird = (number / 100) % 10;
            digitFourth = (number / 10) % 10;
            digitLast = number % 10;

            //check wheather first and last digit are identical
            if (digitFirst == digitLast) {
                System.out.println("Yes.First digit and last digit are identical ");
            } else {
                System.out.println("No.First digit and last digit are not identical ");
            }
            //check wheather second and fourth digit are identical
            if (digitSecond == digitFourth) {
                System.out.println("Yes.Second digit and fourth digit are identical ");
            } else {
                System.out.println("No.Second digit and fourth digit are not identical ");
            }

            if (isPalindrome(userInput)) {
                System.out.println("Yes. The number is palindrome ");
            } else {
                System.out.println("No.The number  is not a palindrome");
            }
        } else {

            System.out.println(userInput + " is not a valid 5 digit number");
        }


    }
}
