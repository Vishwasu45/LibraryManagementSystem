package com.library.system.association;

import com.library.system.management.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryAssociation {

    Scanner sc = new Scanner(System.in);

    private static LibraryAssociation instance = null;

    private List<Library> libraryList = new ArrayList<>();

    private LibraryAssociation() {}

    public static LibraryAssociation getInstance() {
        if (instance == null) {
            instance = new LibraryAssociation();
        }
        return instance;
    }

    public LibraryAssociation(List<Library> libraryList) {
        this.libraryList = libraryList;
    }

    public void handleLibraryAddition() {
        System.out.println("Enter the details of the Library");
        System.out.print("Enter the id of the library : ");
        var id = sc.nextInt();
        System.out.print("Enter the name of the library : ");
        var name = sc.next();
        Library library = new Library(id, name);
        libraryList.add(library);
        System.out.println("Library added successfully");
        System.out.println("*************************");
    }

    public void displayLibraries() {
        System.out.println("List of Libraries in the association are : ");
        libraryList.forEach(Library::displayLibraryName);
        System.out.println("*************************");
    }

    public Library getLibraryById(int id) {
        return libraryList.stream()
                .filter(library -> library.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
