package com.jetbrains;

import java.util.Scanner;

public class BitwiseOperations {

    public static void main(String[] args) {
        int choice = 0;//store operation type
        int first = 0;//store first input integer
        int second = 0;//store second output integer
        int result = 0;//store operation result
        Scanner scanner = new Scanner(System.in);

        //continue execution until user exit
        while (true) {

            System.out.println("\n\nPlease choose the operation : ");
            System.out.printf("%s%s", "1--AND\n2--Inclusive OR\n", "3--Exclusive OR\n4--Complement\n5--Exit\n");

            choice = scanner.nextInt();

            // perform bitwise operation
            switch (choice) {
                case 1: // AND
                    System.out.print("Please enter two integers");
                    first = scanner.nextInt();//get first input integer
                    BitRepresentation.display(first);
                    second = scanner.nextInt();//get second in
                    BitRepresentation.display(second);
                    result = first & second;//perform bitwise AND
                    System.out.printf("\n\n%d & %d = %d",first,second,result);
                    BitRepresentation.display(result);
                    break;
            }
        }
    }
}

