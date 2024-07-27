package com.library.system.management;

import com.library.system.books.Book;
import com.library.system.patrons.Patron;

import java.util.List;

public class Library {

    private int id;

    private String name;

    private List<Book> books;

    private List<Patron> patrons;

    public Library(int id, String name, List<Book> books, List<Patron> patrons) {
        this.id = id;
        this.name = name;
        this.books = books;
        this.patrons = patrons;
    }

    public void addBook(Book book) {
        if (books.stream().noneMatch(b -> b.getIsbn().equalsIgnoreCase(book.getIsbn()))) {
            books.add(book);
        } else {
            System.out.println("This ");
        }
    }

    public void displayLibraryName() {
        System.out.println(this.name);
    }

    public void displayBooks() {
        System.out.println("Books present in " + this.name + " are :");
        books.forEach(book -> System.out.println(book.toString()));
        System.out.println("*************************");
    }
}
