package com.library.system.management;

import com.library.system.books.Book;
import com.library.system.patrons.Patron;

import java.util.ArrayList;
import java.util.List;

public class PatronManager {

    private final List<Patron> patrons = new ArrayList<>();

    public PatronManager() {}

    public PatronManager(List<Patron> patrons) {
        this.patrons.addAll(patrons);
    }

    public void addPatron(Patron patron) {
        this.patrons.add(patron);
        System.out.println("Patron added successfully");
    }

    public void displayPatrons() {
        patrons.forEach(patron -> System.out.println(patron.toString()));
    }

    public Patron getPatronById(int id) {
        return patrons.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Book getBookFromPatron(String isbn, int id) {
        var patron = getPatronById(id);
        if (patron != null) {
            return patron.getBookByIsbn(isbn).orElse(null);
        }
        return null;
    }

    public void lendBook(Book book, Patron patron) {
        patron.borrowBook(book);
    }

    public Book returnBook(Book book, Patron patron) {
        patron.returnBook(book);
        return book;
    }
}
