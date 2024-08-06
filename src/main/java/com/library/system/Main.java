package com.library.system;

import com.library.system.books.Book;
import com.library.system.management.Library;
import com.library.system.association.LibraryAssociation;
import com.library.system.patrons.Patron;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String LIBRARY_NOT_FOUND = "Library not found";

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        /*//Create Books
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
        bangalorePublicLibrary.returnBook(patron1.getBookByIsbn("1").get(), patron1);*/

        Main mainClass = new Main();
        int key;
        var association = new LibraryAssociation();
        do {
            mainClass.displayMenu();
            key = sc.nextInt();
            switch (key) {
                case 1 : {
                    association.handleLibraryAddition();
                    break;
                }
                case 2 : {
                    association.displayLibraries();
                    break;
                }
                case 3 : {
                    System.out.print("Enter the library id to add book : ");
                    var id = sc.nextInt();
                    var library = association.getLibraryById(id);
                    if (library != null) {
                        library.handleBookAddition();
                    } else {
                        System.out.println(LIBRARY_NOT_FOUND);
                    }
                    break;
                }
                case 4 : {
                    System.out.print("Enter the library id to display books : ");
                    var id = sc.nextInt();
                    var library = association.getLibraryById(id);
                    if (library != null) {
                        library.displayBooks();
                    } else {
                        System.out.println(LIBRARY_NOT_FOUND);
                    }
                    break;
                }
                case 5 : {
                    System.out.print("Enter the library id to add patron : ");
                    var id = sc.nextInt();
                    var library = association.getLibraryById(id);
                    if (library != null) {
                        library.handlePatronAddition();
                    } else {
                        System.out.println(LIBRARY_NOT_FOUND);
                    }
                    break;
                }
                case 6 : {
                    System.out.print("Enter the library id to display patrons : ");
                    var id = sc.nextInt();
                    var library = association.getLibraryById(id);
                    if (library != null) {
                        library.displayPatrons();
                    } else {
                        System.out.println(LIBRARY_NOT_FOUND);
                    }
                    break;
                }
                case 7 : {
                    System.out.print("Enter the library id to search books : ");
                    var id = sc.nextInt();
                    var library = association.getLibraryById(id);
                    if (library != null) {
                        library.handleSearchBooks();
                    } else {
                        System.out.println(LIBRARY_NOT_FOUND);
                    }
                    break;
                }
                case 8 : {
                    System.out.print("Enter the library id to lend book : ");
                    var id = sc.nextInt();
                    var library = association.getLibraryById(id);
                    if (library != null) {
                        library.handleLendBook();
                    } else {
                        System.out.println(LIBRARY_NOT_FOUND);
                    }
                    break;
                }
                case 9 : {
                    System.out.print("Enter the library id to return book : ");
                    var id = sc.nextInt();
                    var library = association.getLibraryById(id);
                    if (library != null) {
                        library.handleReturnBook();
                    } else {
                        System.out.println(LIBRARY_NOT_FOUND);
                    }
                    break;
                }
                case 10 : {
                    System.out.print("Enter the library id to show books borrowed by patron : ");
                    var id = sc.nextInt();
                    var library = association.getLibraryById(id);
                    if (library != null) {
                        library.handleShowBooksBorrowedByPatron();
                    } else {
                        System.out.println(LIBRARY_NOT_FOUND);
                    }
                    break;
                }
                case 11 : {
                    System.out.print("Enter the library id to display books borrowed from library : ");
                    var id = sc.nextInt();
                    var library = association.getLibraryById(id);
                    if (library != null) {
                        library.handleShowBooksBorrowedFromLibrary();
                    } else {
                        System.out.println(LIBRARY_NOT_FOUND);
                    }
                    break;
                }
                default: break;
            }
        } while(key != 0);
    }

    public void displayMenu() {
        System.out.println("Enter the key to do the operation : ");
        System.out.println("1. Add library");
        System.out.println("2. Display libraries");
        System.out.println("3. Add Books");
        System.out.println("4. Display books");
        System.out.println("5. Add Patron");
        System.out.println("6. Display Patrons");
        System.out.println("7. Search books");
        System.out.println("8. Borrow book");
        System.out.println("9. Return book");
        System.out.println("10. Show books borrowed by patron");
        System.out.println("11. Display books borrowed from library");
        System.out.print("Choice : ");
    }
}
