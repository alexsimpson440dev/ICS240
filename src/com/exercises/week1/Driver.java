package com.exercises.week1;

public class Driver {
    public static void main(String[] args) {
        Library library = new Library();
        String[] pages = new String[5];
        pages[0] = "title";
        pages[1] = "introduction";


        Book b1 = new Book("Harry Pooter", 1999, pages);
        Book b2 = new Book("Lard of Da Rangs", 1902, pages);
        Book b3 = new Book("Stare Whoas", 1975, pages);

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        library.printBookTitle();
        library.printBookAtIndex(2);
    }

}
