package com.library.system.searching;

import com.library.system.books.Book;

import java.util.List;

public class IsbnSearchStrategy implements SearchStrategy {

    public IsbnSearchStrategy() {
    }

    @Override
    public List<Book> search(String isbn, List<Book> books) {
        return books.stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                .toList();
    }
}
