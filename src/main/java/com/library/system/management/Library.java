package com.library.system.management;

import com.library.system.books.Book;
import com.library.system.patrons.Patron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Library {

    private int id;

    private String name;

    private List<Book> books = new ArrayList<>();

    private List<Patron> patrons = new ArrayList<>();

    private Map<String, Integer> bookMap = new HashMap<>();

    public Library(int id, String name, List<Book> books, List<Patron> patrons) {
        this.id = id;
        this.name = name;
        this.books.addAll(books);
        this.patrons.addAll(patrons);
        populateBookToCountMap(books);
    }

    private void populateBookToCountMap(List<Book> books) {
        books.forEach(book -> {
            if (bookMap.containsKey(book.getIsbn())) {
                this.bookMap.computeIfPresent(book.getIsbn(), (k, v) -> v + 1);
            } else {
                this.bookMap.put(book.getIsbn(), 1);
            }
        });
        displayBooks();
    }

    public void addBook(Book book) {
        if (checkIfBookExists(book.getIsbn())) {
            this.bookMap.computeIfPresent(book.getIsbn(), (k, v) -> v + 1);
        } else {
            populateBookToCountMap(List.of(book));
        }
        this.books.add(book);
    }

    public void displayLibraryName() {
        System.out.println(this.name);
    }

    public void displayBooks() {
        System.out.println("Books present in " + this.name + " are :");
        bookMap.keySet().forEach(key -> {
            var optionalBook = findBookByIsbn(key);
            if (optionalBook.isPresent()) {
                var book = optionalBook.get();
                System.out.println(book + " having count : " + bookMap.get(book.getIsbn()));
            }
        });
        System.out.println("*************************");
    }

    public void displayPatrons() {
        System.out.println("Patrons belonging to " + this.name + " are :");
        patrons.forEach(patron -> System.out.println(patron.toString()));
        System.out.println("*************************");
    }

    public void lendBook(String isbn, Patron patron) {
        if (checkIfBookExists(isbn)) {
            var book = findBookByIsbn(isbn).get();
            patron.borrowBook(book);
            this.bookMap.computeIfPresent(book.getIsbn(), (k, v) -> v - 1);
            this.books.remove(book);
            displayBooks();
        }
    }

    public void returnBook(Book book, Patron patron) {
        patron.returnBook(book);
        this.bookMap.computeIfPresent(book.getIsbn(), (k, v) -> v + 1);
        this.books.add(book);
        displayBooks();
    }

    private Optional<Book> findBookByIsbn(String isbn) {
        return this.books.stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    private Optional<Book> findBookByAuthor(String author) {
        return this.books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .findFirst();
    }

    private Optional<Book> findBookByTitle(String title) {
        return this.books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    private boolean checkIfBookExists(String isbn) {
        return bookMap.getOrDefault(isbn, 0) > 0;
    }
}
