package com.exercises.week2;

import java.util.Scanner;

public class ArrayOfIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int SIZE = 5;
        int[] integerArray = new int[SIZE];

        // read in values
        for(int i = 0; i < integerArray.length; i++) {
            System.out.print("Enter integer #");
            integerArray[i] = scanner.nextInt();
        }

        int max = integerArray[0];
        int min = integerArray[0];
        int sum = 0, evens = 0, odds = 0;
        int average;
        boolean containsFifty = false;

        for(int i = 0; i < integerArray.length; i++) {
            sum += integerArray[i];

            if(integerArray[i] % 2 == 0) {
                evens++;
            } else {
                odds++;
            }

            if(integerArray[i] > max) {
                max = integerArray[i];
            }

            if(integerArray[i] < min) {
                min = integerArray[i];
            }

            if(integerArray[i] == 50) {
                containsFifty = true;
            }
        }

        // printing the array
        for(int i = 0; i < integerArray.length; i++) {
            System.out.println(integerArray[i] + " ");
        }

        System.out.println("Max: " + max + "\nMin: " + min + "\nEvens: " + evens);
        System.out.println("Odds: " + odds + "\nSum: " + sum + "\n50?: " + containsFifty);
        System.out.println("Average: " + (double) sum / SIZE);
    }
}
