package com.library.system.management;

import com.library.system.books.Book;
import com.library.system.patrons.Patron;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Library {

    private int id;

    private String name;

    private List<Book> books;

    private List<Patron> patrons;

    private Map<Book, Integer> bookMap = new HashMap<>();

    public Library(int id, String name, List<Book> books, List<Patron> patrons) {
        this.id = id;
        this.name = name;
        this.books = books;
        this.patrons = patrons;
        populateBookToCountMap(books);
    }

    private void populateBookToCountMap(List<Book> books) {
        books.forEach(book -> {
            if (bookMap.containsKey(book)) {
                this.bookMap.computeIfPresent(book, (k, v) -> v + 1);
            } else {
                this.bookMap.put(book, 1);
            }
        });
        displayBooks();
    }

    public void addBook(Book book) {
        if (checkIfBookExists(book)) {
            this.bookMap.computeIfPresent(book, (k, v) -> v + 1);
        } else {
            populateBookToCountMap(List.of(book));
        }
    }

    public void displayLibraryName() {
        System.out.println(this.name);
    }

    public void displayBooks() {
        System.out.println("Books present in " + this.name + " are :");
        System.out.println(bookMap);
        System.out.println("*************************");
    }

    public void displayPatrons() {
        System.out.println("Patrons belonging to " + this.name + " are :");
        patrons.forEach(patron -> System.out.println(patron.toString()));
        System.out.println("*************************");
    }

    public void lendBook(Book book, Patron patron) {
        if (patron.getBorrowedBooks().contains(book)) {
            System.out.println("Patron already has the book");
        } else if (checkIfBookExists(book)) {
            patron.borrowBook(book);
            this.bookMap.computeIfPresent(book, (k, v) -> v - 1);
            displayBooks();
        }
    }

    private boolean checkIfBookExists(Book book) {
        return bookMap.getOrDefault(book, 0) > 0;
    }
}
