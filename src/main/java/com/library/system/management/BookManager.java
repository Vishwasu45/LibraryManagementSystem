package com.library.system.management;

import com.library.system.books.Book;
import com.library.system.searching.IsbnSearchStrategy;
import com.library.system.searching.SearchStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookManager {

    private List<Book> books = new ArrayList<>();

    private Map<String, Integer> bookMap = new HashMap<>();

    public BookManager() {
    }

    public BookManager(List<Book> books) {
        this.books.addAll(books);
        populateBookToCountMap(books);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        if (checkIfBookExists(book.getIsbn())) {
            this.bookMap.computeIfPresent(book.getIsbn(), (k, v) -> v + 1);
        } else {
            populateBookToCountMap(List.of(book));
        }
        this.books.add(book);
        System.out.println("Book added successfully");
    }

    private void populateBookToCountMap(List<Book> books) {
        books.forEach(book -> {
            if (bookMap.containsKey(book.getIsbn())) {
                this.bookMap.computeIfPresent(book.getIsbn(), (k, v) -> v + 1);
            } else {
                this.bookMap.put(book.getIsbn(), 1);
            }
        });
    }

    public List<Book> searchBook(SearchStrategy strategy, String param) {
        return strategy.search(param, books);
    }

    public Book getBookToLend(String isbn) {
        if (checkIfBookExists(isbn)) {
            var book = searchBook(new IsbnSearchStrategy(), isbn).stream().findFirst().orElse(null);
            assert book != null;
            this.bookMap.computeIfPresent(book.getIsbn(), (k, v) -> v - 1);
            this.books.remove(book);
            return book;
        }
        return null;
    }

    public void returnBook(Book book) {
        this.bookMap.computeIfPresent(book.getIsbn(), (k, v) -> v + 1);
        this.books.add(book);
        displayBooks();
    }

    private boolean checkIfBookExists(String isbn) {
        return bookMap.getOrDefault(isbn, 0) > 0;
    }

    public void displayBooks() {
        bookMap.keySet().forEach(key -> searchBook(new IsbnSearchStrategy(), key)
                .stream()
                .findFirst()
                .ifPresent(book -> System.out.println(book + " having count : " + bookMap.get(book.getIsbn()))));
    }
}
