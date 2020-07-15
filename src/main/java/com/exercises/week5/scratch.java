package com.exercises.week5;

public class scratch {
    public static void main(String[] args) {
        IntLinkedStack s1 = new IntLinkedStack();
        s1.push(1);
        s1.push(2);
        s1.push(3);

        System.out.println(s1);
        System.out.println(bottomValue(s1));
        System.out.println(s1);
    }

    public static int bottomValue(IntLinkedStack s1) {
        int size = s1.size();
        for(int i = 0; i < size; i++) {
            if(i == size-1) {
                return s1.pop();
            }
            s1.pop();
        }

        return -1;
    }
}
