package com.labs.week3;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        double[] array = new double[5];

        // auto fill array
        for(int i = 0; i < array.length; i++) {
            array[i] = (Math.random() * 100);
        }

//        array[0] = 5;
//        array[1] = 0;
//        array[2] = 0;
//        array[3] = 5;
//        array[4] = 7;

        // original array
        System.out.println("---- Original Array ----");
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        // sorted array
        System.out.println("---- Sorted Array ----");
        array = sortArray(array);
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static double[] sortArray(double[] array) {
        double[] sortedArray = new double[array.length];
        int counter =  0;

        // chose a while loop because with the for loop, the i gets closer to the length which is being shortened
        // this means that if you are on index say 3 of 5 you are really on your last index
        while(array.length > 0) {
            // gets max value index and sets the sorted array to the max value
            int max = getMaxValueIndex(array);
            sortedArray[counter] = array[max];

            if(max == array.length-1) {
                // max index is the last in the array, clone here
                array = Arrays.copyOf(array, array.length-1);
            } else {
                // set values to be swapped
                double lastValue = array[array.length-1];
                double maxValue = array[max];

                // swap values
                array[array.length-1] = maxValue;
                array[max] = lastValue;

                // drop last index in array
                array = Arrays.copyOf(array, array.length-1);
            }
            counter++;
        }

        return sortedArray;
    }

    // gets the index of the max value
    public static int getMaxValueIndex(double[] array) {
        int max = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }
}
