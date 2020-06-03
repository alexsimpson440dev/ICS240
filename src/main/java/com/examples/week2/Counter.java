package com.examples.week2;

public class Counter {
    private String id;
    private int count;

    public Counter() {}

    public Counter(String id, int count) {
        this.id = id;
        this.count = count;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    public static String maximum(Counter c1, Counter c2) {
        if(c1.tally() > c2.tally()) {
            return c1.id;
        } else if(c2.tally() > c1.tally()) {
            return c2.id;
        } else {
            return "No maximum";
        }
    }

    @Override
    public String toString() {
        return id + ": " + count;
    }
}
