package com.assignments.assignment2;

public class Driver {
    public static void main(String[] args) {
        Engine dsm = new Engine("4G63T", 122);
        Engine eclipse = new Engine("4G63", 122);
        Engine miata = new Engine("BP-4W", 110);

//        System.out.println(dsm.compareTo(miata));
//        System.out.println(miata.compareTo(dsm));
//        System.out.println(dsm.compareTo(dsm));
//        System.out.println(dsm.compareTo(eclipse));
//        System.out.println(eclipse.compareTo(dsm));

        EngineSortedArrayBag bag = new EngineSortedArrayBag();
        bag.add("5", 0);
        bag.add("C", 0);
        bag.add("B", 0);
        bag.add("W", 0);
        bag.add("10", 0);
        bag.add("A", 0);
        bag.add("10", 20);
        bag.add("1", 0);
        bag.add("Z", 10);
        bag.add("Z", 11);
        bag.add("Y", 30);

        for(int i = 0; i < bag.getEngineArray().length; i++) {
            System.out.println(bag.getEngineArray()[i]);
        }
    }
}
