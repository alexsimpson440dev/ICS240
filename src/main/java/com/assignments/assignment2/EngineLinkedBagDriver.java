package com.assignments.assignment2;

public class EngineLinkedBagDriver {
    public static void main(String[] args) {
        EngineLinkedBag engineLinkedBag = new EngineLinkedBag();
        engineLinkedBag.add(new Engine("4", 4));
        engineLinkedBag.add(new Engine("3", 3));
        engineLinkedBag.add(new Engine("1", 1));
        engineLinkedBag.display(); // display before adding to position 2

        engineLinkedBag.add(2, new Engine("2", 2));
        engineLinkedBag.display(); // display after adding to position 2

        engineLinkedBag.remove(new Engine("2", 2));
        engineLinkedBag.display(); // display after removing 2

        engineLinkedBag.remove(1);
        engineLinkedBag.display(); // display after removing link at position 1

        engineLinkedBag.removeLast();
        engineLinkedBag.removeLast();

        engineLinkedBag.display(); // display after removing last link

        System.out.println(engineLinkedBag.grab(1));
        System.out.println(engineLinkedBag.positionOf(new Engine("3", 3)));

        // resetting the bag
        engineLinkedBag.add(new Engine("4", 4));
        engineLinkedBag.add(new Engine("3", 3));
        engineLinkedBag.add(new Engine("1", 1));
        engineLinkedBag.display(); // display before setting 4 to 5

        engineLinkedBag.set(3, new Engine("5", 5));
        engineLinkedBag.display(); // displays new bag

        System.out.println(engineLinkedBag.totalValue()); // should return 9
        System.out.println(engineLinkedBag.getMax());
    }
}
