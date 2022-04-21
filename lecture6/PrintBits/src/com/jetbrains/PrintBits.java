package com.jetbrains;

import java.util.Scanner;

public class PrintBits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer : ");

        int input = scanner.nextInt();

        //display bit representation of an integer
        System.out.println("The integer in bits is: ");

        //create int value with 1 in leftmost bit and 0s elsewhere
        int displayMask = 1 << 31;
        //for each bit display 0 or 1

        for (int bit = 1; bit <= 32; bit++) {
            //use displayMask to isolate bit
            if((input&displayMask) == 0){
                System.out.print('0');
            }
            else{
                System.out.print('1');
            }

            input <<= 1;//shift value one position to left

            if (bit % 8 == 0) {
                System.out.print(' ');//display space every 8 bits
            }
        }


    }
}
