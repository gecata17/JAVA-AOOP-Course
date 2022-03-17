package com.jetbrains;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int digitLast = number % 10;
        int digitThird = (number / 10) % 10;
        int digitSecond = (number / 100) % 10;
        int digitFirst = number / 1000;


        int digitLastNew = (digitLast + 7) % 10;
        int digitThirdNew = (digitThird + 7) % 10;
        int digitSecondNew = (digitSecond + 7) % 10;
        int digitFirstNew = (digitFirst + 7) % 10;

        System.out.println(digitFirstNew);
        System.out.println(digitLastNew);
        System.out.println(digitSecondNew);
        System.out.println(digitThirdNew);

        int swapper = 0;
        swapper = digitFirstNew;
        digitFirstNew = digitThirdNew;
        digitThirdNew = swapper;

        swapper = digitSecondNew;
        digitSecondNew = digitLastNew;
        digitLastNew = swapper;

        number = digitFirstNew * 1000 + digitSecondNew * 100 + digitThirdNew * 10 + digitLastNew;

        System.out.println(number);
    }
}


