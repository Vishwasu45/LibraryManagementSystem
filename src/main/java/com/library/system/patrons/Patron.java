package com.library.system.patrons;

import com.library.system.books.Book;

import java.util.ArrayList;
import java.util.List;

public class Patron {

    private int id;

    private String name;

    private List<Book> borrowedBooks = new ArrayList<>();

    public Patron(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        this.borrowedBooks.add(book);
        this.displayBooksHeldByPatron();
    }

    public void returnBook(Book book) {
        this.borrowedBooks.remove(book);
        this.displayBooksHeldByPatron();
    }

    private void displayBooksHeldByPatron() {
        System.out.println(this.name + " has these books : ");
        this.borrowedBooks.forEach(borrowed -> System.out.println(borrowed.toString()));
        System.out.println("*************************");
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name;
    }
}
