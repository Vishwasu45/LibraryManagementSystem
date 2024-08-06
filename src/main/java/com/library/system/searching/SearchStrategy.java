package com.library.system.searching;

import com.library.system.books.Book;

import java.util.List;

public interface SearchStrategy {

    List<Book> search(String searchParam, List<Book> books);
}
