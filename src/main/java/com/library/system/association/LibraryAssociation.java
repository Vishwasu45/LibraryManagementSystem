package com.library.system.association;

import com.library.system.management.Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryAssociation {

    private List<Library> libraryList = new ArrayList<>();

    public List<Library> getLibraryList() {
        return libraryList;
    }

    public void setLibraryList(List<Library> libraryList) {
        this.libraryList = libraryList;
    }

    public LibraryAssociation(List<Library> libraryList) {
        this.libraryList = libraryList;
    }

    public void displayLibraries() {
        System.out.println("List of Libraries in the association are : ");
        libraryList.forEach(Library::displayLibraryName);
        System.out.println("*************************");
    }
}
