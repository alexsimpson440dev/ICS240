package com.labs.week6;

import java.util.LinkedList;
import java.util.Queue;

public class Week6 {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        //System.out.println(getAtIndex1(queue, 3));
        System.out.println(queue);
        //getAtIndex2(queue, 2);
        System.out.println(getAtIndex3(queue, 4));
        System.out.println(queue);
    }

    public static int getAtIndex1(Queue<Integer> inputQ, int index) {
        if(inputQ.size() <= index || index < 0) {
            return -1;
        } else {
            int indexValue = -1;
            for(int i = 0; i <= inputQ.size(); i++) {
                if(i == index) {
                    indexValue = inputQ.remove();
                } else {
                    inputQ.add(inputQ.remove());
                }
            }

            return indexValue;
        }
    }

    public static void getAtIndex2(Queue<Integer> inputQ, int index) {
        if(inputQ.size() <= index || index < 0) {
            System.out.println("Index out of range");
        } else {
            Queue<Integer> newQueue = new LinkedList<>();
            for(int i = 0; i < inputQ.size(); i++) {
                if(i == index) {
                    inputQ.add(inputQ.remove());
                } else {
                    int value = inputQ.remove();
                    newQueue.add(value);
                    inputQ.add(value);
                }
            }
            System.out.println(newQueue);
        }
    }

    public static int getAtIndex3(Queue<Integer> inputQ, int index) {
        if(inputQ.size() <= index || index < 0) {
            return -1;
        } else {
            int indexValue = -1;
            for(int i = 0; i < inputQ.size(); i++) {
                if(i == index) {
                    indexValue = inputQ.remove();
                    inputQ.add(indexValue);
                } else {
                    inputQ.add(inputQ.remove());
                }
            }

            return indexValue;
        }
    }
}
