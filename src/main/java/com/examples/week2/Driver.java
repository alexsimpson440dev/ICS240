package com.examples.week2;

public class Driver {
    public static void main(String[] args) {
        Counter heads = new Counter("heads", 0);
        Counter tails = new Counter("tails", 0);

        for(int i = 0; i < 100; i++) {
            int randomVal = (int) (Math.random() * 100);

            if(randomVal % 2 == 0) {
                heads.increment();
            } else {
                tails.increment();
            }
        }

        System.out.println(heads);
        System.out.println(tails);
    }
}
