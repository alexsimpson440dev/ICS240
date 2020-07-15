package com.exercises.week6;

import java.util.LinkedList;
import java.util.Queue;

public class Exercise6 {
    public static void main(String[] args) {

        // EXERCISE 1
//        Queue<Integer> q1 = new LinkedList<Integer>();
//
//        q1.add(0);
//        q1.add(1);
//
//        for(int i = 0; i < 10; i++) {
//            int a = q1.remove();
//            int b = q1.remove();
//            q1.add(b);
//            q1.add(a+b);
//            System.out.println(a);
//        }

        // my answer: NOTES: a is always the output, b is always the first in the queue
        // 0: a = 0; b = 1; new queue (1, 1); output: 0
        // 1: a = 1; b = 1; new queue (1, 2); output: 1
        // 2: a = 1; b = 2; new queue (2, 3); output: 1
        // 3: a = 2; b = 3; new queue (3, 5); output: 2
        // 4: a = 3; b = 5; new queue (5, 8); output: 3
        // 5: a = 5; b = 8; new queue (8, 13); output: 5
        // 6: a = 8; b = 13; new queue (13, 21); output: 8
        // 7: a = 13; b = 21; new queue (21, 34); output: 13
        // 8: a = 21; b = 34; new queue (34, 55); output: 21
        // 9: a = 34; b = 55; new queue (55, 89); output: 34

        // expected output when ran: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        // YAY!

        // EXERCISE 2
            // capacity = 5

            // private int[] data;
            // private int front;
            // private int rear;
            // private int manyItems;

            // Variables in order as listed above:
            // q1.add(1) - [1, 0, 0, 0, 0]; 0; 0; 1;
            // q1.add(2) - [1, 2, 0, 0, 0]; 0; 1; 2;
            // q1.add(3) - [1, 2, 3, 0, 0]; 0; 2; 3;
            // q1.remove() - [1, 2, 3, 0, 0]; 1; 2; 2;
            // q1.add(4) - [1, 2, 3, 4, 0]; 1, 3, 3;
            // q1.add(5) - [1, 2, 3, 4, 5]; 1; 4; 4;
            // q1.add(6) - [6, 2, 3, 4, 5]; 1; 0; 5;
            // q1.remove() - [6, 2, 3, 4, 5]; 2; 0; 4;
            // q1.add(7) - [6, 7, 3, 4, 5]; 2; 1; 5;
    }
}
