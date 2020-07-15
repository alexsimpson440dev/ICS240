package com.exercises.week6;

public class scratch {
    public static void main(String[] args) {
        IntArrayQueue q1 = new IntArrayQueue(5);
        IntArrayQueue q2 = new IntArrayQueue(5);
        q1.add(0);
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);

        q2.add(0);
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(8);

        System.out.println(q1.compareTo(q2));
    }
}
