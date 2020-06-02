package com.exercises.week3;

public class Driver {
    public static void main(String[] args) {
        IntArrayBag bag1 = new IntArrayBag();
        IntArrayBag bag2 = new IntArrayBag();
        IntArrayBag bag3 = new IntArrayBag();

        bag1.add(5);
        bag1.add(6);
        bag1.add(4);

        bag2.add(5);
        bag2.add(6);
        bag2.add(4);

        bag3.add(1);
        bag3.add(2);
        bag3.add(3);

        // test sumEven
        System.out.println(IntArrayBag.sumEven(bag1));
        System.out.println(bag1.sumEven());

        // test max
        System.out.println(bag3.max());
        System.out.println(bag1.max());

        // test equalsTo
        System.out.println(bag1.equalsTo(bag2));
        System.out.println(bag1.equalsTo(bag3));
        System.out.println(equalsTo(bag1, bag2));
        System.out.println(equalsTo(bag2, bag3));

    }

    public static boolean equalsTo(IntArrayBag bag1, IntArrayBag bag2) {
        return bag1.equalsTo(bag2);
    }
}
