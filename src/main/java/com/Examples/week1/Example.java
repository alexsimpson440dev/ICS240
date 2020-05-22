package com.Examples.week1;

public class Example {
    public static void main(String[] args) {
        int x = 5;
        int[] values = new int[100];

        seeValue(99, values);
    }

    public int[] resetArray(int arraySize) {
        return new int[arraySize];
    }

    public static void seeValue(int index, int[] values) {
        if(index < values.length && index >= 0) {
            System.out.println(values[index]);
        } else {
            System.out.println("index out of range");
        }
    }
}
