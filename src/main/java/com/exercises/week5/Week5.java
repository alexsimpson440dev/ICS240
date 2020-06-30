package com.exercises.week5;

public class Week5 {
    public static void main(String[] args) {
        IntLinkedStack stack = new IntLinkedStack();
        stack.push(5);
        stack.push(2);
        stack.empty();
        System.out.println(stack);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        stack = IntLinkedStack.reverse(stack);
        System.out.println(stack);
    }
}
