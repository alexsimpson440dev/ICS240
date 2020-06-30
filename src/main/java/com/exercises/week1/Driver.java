package com.exercises.week1;

public class Driver {
    public static void main(String[] args) {
        Library library = new Library();
        String[] pages = new String[5];
        pages[0] = "title";
        pages[1] = "introduction";

        Book[] books = new Book[20];

        System.out.println(Book.getCount());
        int count = 14;





        Book b1 = new Book("Harry Pooter", 1999, pages);
        Book b2 = new Book("Lard of Da Rangs", 1902, pages);
        Book b3 = new Book("Stare Whoas", 1975, pages);

        books[13] = b3;
        books[12] = b2;
        books[11] = b1;

        for(int i = count-1; i >= 0; i--) {
            System.out.println(books[i]);
        }


//        library.addBook(b1);
//        library.addBook(b2);
//        library.addBook(b3);
//
//        library.printBookTitle();
//        library.printBookAtIndex(2);
    }
}
