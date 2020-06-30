package com.assignments.assignment2;

public class Driver {
    public static void main(String[] args) {
        Engine dsm = new Engine("4G63T", 122);
        Engine eclipse = new Engine("4G63", 122);
        Engine miata = new Engine("BP-4W", 110);

        System.out.println(dsm.compareTo(miata));
        System.out.println(miata.compareTo(dsm));
        System.out.println(dsm.compareTo(dsm));
        System.out.println(dsm.compareTo(eclipse));
        System.out.println(eclipse.compareTo(dsm));
    }
}
