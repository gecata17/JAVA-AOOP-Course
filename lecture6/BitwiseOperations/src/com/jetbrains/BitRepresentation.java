package com.jetbrains;

public class BitRepresentation {

    public static void display(int value) {
        System.out.printf("\nBit representation of %d is: \n", value);

        //create int value with 1 in leftmost bit and 0s elsewhere
        int displayMask = 1 << 31;

        //for each bit display 0 or 1

        for (int bit = 1; bit <= 32; bit++) {
            if ((value & displayMask) == 0) {
                System.out.print('0');
            } else {
                System.out.print('1');
            }

            value <<= 1;//shift value one position to left

            if (bit % 8 == 0) {
                System.out.print(' ');//display space every 8 bits
            }
        }
    }
}
