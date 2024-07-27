package com.library.system;

import com.library.system.books.Book;
import com.library.system.management.Library;
import com.library.system.association.LibraryAssociation;
import com.library.system.patrons.Patron;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Create Books
        Book book1 = new Book("Learn Java", "John", "1", 2010);
        Book book2 = new Book("DSA", "Jacob", "2", 2014);

        Book book3 = new Book("Learn Python", "Vincent", "3", 2010);
        Book book4 = new Book("Swift UI", "Chase", "4", 2014);

        //Create Patrons
        Patron patron1 = new Patron(1, "Jason");
        Patron patron2 = new Patron(2, "Jamy");

        Patron patron3 = new Patron(3, "Bill");
        Patron patron4 = new Patron(4, "Sammy");

        //Create Libraries
        Library bangalorePublicLibrary = new Library(1, "Bangalore Public library", List.of(book1, book2), List.of(patron1, patron2));
        Library punePublicLibrary = new Library(2, "Pune Public library", List.of(book3, book4), List.of(patron3, patron4));

        //Add libraries to Library Association
        LibraryAssociation association = new LibraryAssociation(List.of(bangalorePublicLibrary, punePublicLibrary));
        association.displayLibraries();

        //Display books and patrons present in each library
        association.getLibraryList().forEach(Library::displayBooks);
        association.getLibraryList().forEach(Library::displayPatrons);

        //Add same book to library to increase the count
        bangalorePublicLibrary.addBook(new Book("Learn Java", "John", "1", 2010));
        bangalorePublicLibrary.addBook(new Book("Learn Java", "John", "1", 2010));
        bangalorePublicLibrary.displayBooks();

        //Lend book to patron
        System.out.println("Lending Book");
        bangalorePublicLibrary.lendBook("1", patron1);
        bangalorePublicLibrary.lendBook("1", patron2);
        bangalorePublicLibrary.lendBook("1", patron2);

        //Return book from patron
        System.out.println("Returning Book");
        bangalorePublicLibrary.returnBook(patron1.getBookByIsbn("1").get(), patron1);
    }
}
