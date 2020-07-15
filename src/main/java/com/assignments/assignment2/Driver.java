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
        bag.add("4G63T", 122);
        bag.add("BP-4W", 110);
        bag.add("4G63", 122);
        bag.add("4G638", 122);
        bag.add("4G638", 122);

        EngineSortedArrayBag bag2 = new EngineSortedArrayBag();
        bag2.add("4G63T", 122);
        bag2.add("BP-4W", 110);
        bag2.add("4G63", 122);
        bag2.add("4G638", 122);
        bag2.add("4G637", 122);

        for(Engine i: bag) {
            System.out.println(i);
        }

//        System.out.println(bag.toString());
//        System.out.println();
//        System.out.println(bag.total());
//        bag.replace(dsm, miata);
//        System.out.println(bag.toString());
//        bag.remove(dsm);
//        bag.remove(eclipse);
//        bag.remove(miata);
//
//        bag.add("4G63", 122);
//        bag.add("4G63T", 122);
//        bag.add("BP-4W", 110);

//        for(int i = 0; i < bag.getEngineArray().length; i++) {
//            System.out.println(bag.getEngineArray()[i]);
//        }
    }
}
