package com.library.system.searching;

import com.library.system.books.Book;

import java.util.List;

public class TitleSearchStrategy implements SearchStrategy {


    public TitleSearchStrategy() {
    }

    @Override
    public List<Book> search(String title, List<Book> books) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .toList();
    }
}
