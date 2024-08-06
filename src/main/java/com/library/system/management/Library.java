package com.library.system.management;

import com.library.system.books.Book;
import com.library.system.patrons.Patron;
import com.library.system.searching.AuthorSearchStrategy;
import com.library.system.searching.IsbnSearchStrategy;
import com.library.system.searching.SearchStrategy;
import com.library.system.searching.TitleSearchStrategy;

import java.util.List;
import java.util.Scanner;

public class Library {

    private int id;

    private String name;

    private BookManager bookManager;

    private PatronManager patronManager;

    private InventoryManager inventoryManager;

    private Scanner sc = new Scanner(System.in);

    public Library(int id, String name, List<Book> books, List<Patron> patrons) {
        this.id = id;
        this.name = name;
        this.bookManager = new BookManager(books);
        this.patronManager = new PatronManager(patrons);
    }

    public Library(int id, String name) {
        this.id = id;
        this.name = name;
        this.bookManager = new BookManager();
        this.patronManager = new PatronManager();
        this.inventoryManager = new InventoryManager();
    }

    public int getId() {
        return id;
    }

    public BookManager getBookManager() {
        return bookManager;
    }

    public PatronManager getPatronManager() {
        return patronManager;
    }

    public void handleBookAddition() {
        System.out.println("Enter the details of the Book");
        System.out.print("Enter the title of the book : ");
        var name = sc.next();
        System.out.print("Enter the author of the book : ");
        var author = sc.next();
        System.out.print("Enter the isbn of the book : ");
        var isbn = sc.next();
        System.out.print("Enter the publication year of the book : ");
        var publicationYear = sc.nextInt();
        Book book = new Book(name, author, isbn, publicationYear);
        bookManager.addBook(book);
    }

    public void handlePatronAddition() {
        System.out.println("Enter the details of the Patron");
        System.out.print("Enter the id of the patron : ");
        var id = sc.nextInt();
        System.out.print("Enter the name of the patron : ");
        var name = sc.next();
        Patron patron = new Patron(id, name);
        patronManager.addPatron(patron);
    }

    public void handleSearchBooks() {
        displaySearchCriteria();
        var criteria = sc.nextInt();
        var searchStrategy = getStrategy(criteria);
        System.out.print("Enter the parameter to search : ");
        var searchParam = sc.next();
        var book = searchStrategy.search(searchParam, bookManager.getBooks());
        if (book != null) {
            System.out.println("Book found : " + book);
        } else {
            System.out.println("Book not found");
        }
    }

    public void handleShowBooksBorrowedByPatron() {
        System.out.print("Enter the patron id to show books borrowed : ");
        var patronId = sc.nextInt();
        var patron = patronManager.getPatronById(patronId);
        if (patron != null) {
            patron.displayBooksBorrowedByPatron();
        } else {
            System.out.println("Patron not found");
        }
    }

    public SearchStrategy getStrategy(int criteria) {
        return switch (criteria) {
            case 1 -> new AuthorSearchStrategy();
            case 2 -> new IsbnSearchStrategy();
            case 3 -> new TitleSearchStrategy();
            default -> null;
        };
    }

    public void displaySearchCriteria() {
        System.out.println("1. By Author");
        System.out.println("2. By Isbn");
        System.out.println("3. By Title");
        System.out.print("Enter the search criteria : ");
    }

    public void addBook(Book book) {
        bookManager.addBook(book);
    }

    public void displayLibraryName() {
        System.out.println(this.name);
    }

    public void displayBooks() {
        System.out.println("Books present in " + this.name + " are : ");
        bookManager.displayBooks();
        System.out.println("*************************");
    }

    public void displayPatrons() {
        System.out.println("Patrons belonging to " + this.name + " are : ");
        patronManager.displayPatrons();
        System.out.println("*************************");
    }

    public void handleLendBook() {
        System.out.print("Enter the isbn of the book to borrow : ");
        var isbn = sc.next();
        System.out.print("Enter the patron id to lend the book : ");
        var patronId = sc.nextInt();
        var patron = patronManager.getPatronById(patronId);
        if (patron != null) {
            lendBook(isbn, patron);
        } else {
            System.out.println("Patron not found");
        }
    }

    public void lendBook(String isbn, Patron patron) {
        var book = bookManager.getBookToLend(isbn);
        if (book != null) {
            patronManager.lendBook(book, patron);
            inventoryManager.updateBooksBorrowed(patron, book);
        }
    }

    public void handleReturnBook() {
        System.out.print("Enter the isbn of the book to return : ");
        var isbn = sc.next();
        System.out.print("Enter the patron id to return the book : ");
        var patronId = sc.nextInt();
        var patron = patronManager.getPatronById(patronId);
        if (patron != null) {
            var book = patronManager.getBookFromPatron(isbn, patronId);
            returnBook(book, patron);
        } else {
            System.out.println("Patron not found");
        }
    }

    public void returnBook(Book book, Patron patron) {
        var returnedBook = patronManager.returnBook(book, patron);
        bookManager.returnBook(returnedBook);
    }

    public void handleShowBooksBorrowedFromLibrary() {
        inventoryManager.displayBooksBorrowedFromLibrary();
    }
}
