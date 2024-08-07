package com.library.system.handlers;

import com.library.system.association.LibraryAssociation;
import com.library.system.common.Constants;
import com.library.system.common.ScannerProvider;

import java.util.Scanner;

public class DisplayBooksByLibraryHandler implements InputHandler {

    private static final Scanner sc = ScannerProvider.getInstance().getScanner();

    @Override
    public void handleInput() {
        var association = LibraryAssociation.getInstance();
        System.out.print("Enter the library id to display books : ");
        var id = sc.nextInt();
        var library = association.getLibraryById(id);
        if (library != null) {
            library.displayBooks();
        } else {
            System.out.println(Constants.LIBRARY_NOT_FOUND);
        }
    }
}
