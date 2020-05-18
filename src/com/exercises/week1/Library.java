package com.exercises.week1;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public Library() {

    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void printBookTitle() {
        for(int i=0; i < books.size(); i++) {
            System.out.println(books.get(i).getTitle());
        }
    }

    public void printBookAtIndex(int index) {
        System.out.println(books.get(index));
    }
}
