package com.library.system;

import com.library.system.books.Book;
import com.library.system.management.Library;
import com.library.system.association.LibraryAssociation;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Create Books
        Book book1 = new Book("Learn Java", "John", "1", 2010, 2);
        Book book2 = new Book("DSA", "Jacob", "2", 2014, 2);

        Book book3 = new Book("Learn Python", "Vincent", "3", 2010, 2);
        Book book4 = new Book("Swift UI", "Chase", "4", 2014, 2);

        //Create Libraries
        Library bangalorePublicLibrary = new Library(1, "Bangalore Public library", List.of(book1, book2));
        Library punePublicLibrary = new Library(2, "Pune Public library", List.of(book3, book4));

        //Add libraries to Library Association
        LibraryAssociation association = new LibraryAssociation(List.of(bangalorePublicLibrary, punePublicLibrary));
        association.displayLibraries();

        //Display books present in each library
        association.getLibraryList().forEach(Library::displayBooks);
    }
}
