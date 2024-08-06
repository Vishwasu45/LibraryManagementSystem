package com.library.system.management;

import com.library.system.books.Book;
import com.library.system.patrons.Patron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {

    private Map<Patron, List<Book>> borrowedBooks = new HashMap<>();

    public InventoryManager() {
    }

    public void updateBooksBorrowed(Patron patron, Book book) {
        borrowedBooks.computeIfAbsent(patron, k -> new ArrayList<>())
                .add(book);
    }

    public void displayBooksBorrowedFromLibrary() {
        borrowedBooks.forEach((patron, books) -> {
            System.out.println("Patron : " + patron.toString());
            System.out.println("Books borrowed by the patron : ");
            books.forEach(book -> System.out.println(book.toString()));
            System.out.println("*************************");
        });
    }
}
