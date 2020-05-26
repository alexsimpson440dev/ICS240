package com.exercises.week2;

import java.util.Scanner;

public class ArrayOfLines {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int SIZE = 3;
        Line[] lineArr = new Line[SIZE];
        double max = 0, min = 0, sum = 0;
        Line longestLine = lineArr[0];
        int linesGreaterThan50 = 0;
        boolean zeroZeroPoint = false;

        for(int i=0; i < lineArr.length; i++) {
            System.out.println("Enter start-x of line#"+i);
            int startX = scan.nextInt();
            System.out.println("Enter start-y of line#"+i);
            int startY = scan.nextInt();
            System.out.println("Enter end-x of line#"+i);
            int endX = scan.nextInt();
            System.out.println("Enter end-y of line#"+i);
            int endY = scan.nextInt();
            lineArr[i] = new Line(startX, startY, endX, endY);
        }

        for(int i=0; i < lineArr.length; i++) {
            double length = lineArr[i].length();
            sum += length;

            // set max and min
            // max also sets the longest line to prevent another if
            if(length > max) {
                max = length;
                longestLine = lineArr[i];
            }

            if(length < min) {
                min = length;
            }

            if(length > 50) {
                linesGreaterThan50++;
            }

            if(lineArr[i].getStart().equals(new Point(0, 0)) ||
                    lineArr[i].getEnd().equals(new Point(0, 0))) {
                zeroZeroPoint = true;
            }
        }

        // printing the array
        for(int i=0; i < lineArr.length; i++) {
            System.out.println(lineArr[i]);
        }

        // print other values
        System.out.println("Max line length: " + max + "\nMin line length: " + min + "\nLongest line: " + longestLine +
                "\nAverage Line Length: " + (sum/lineArr.length) +
                "\nAmount of lines greater than 50: " + linesGreaterThan50 +
                "\nContains a point at (0,0): " + zeroZeroPoint);
    }
}
