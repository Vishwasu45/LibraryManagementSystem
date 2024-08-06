package com.library.system.searching;

import com.library.system.books.Book;

import java.util.List;

public class AuthorSearchStrategy implements SearchStrategy {

    public AuthorSearchStrategy() {
    }

    @Override
    public List<Book> search(String author, List<Book> books) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .toList();
    }
}
