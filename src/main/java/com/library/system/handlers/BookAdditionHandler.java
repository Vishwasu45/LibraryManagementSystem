package com.library.system.handlers;

import com.library.system.association.LibraryAssociation;
import com.library.system.common.Constants;
import com.library.system.common.ScannerProvider;

import java.util.Scanner;

public class BookAdditionHandler implements InputHandler {

    private static final Scanner sc = ScannerProvider.getInstance().getScanner();

    @Override
    public void handleInput() {
        LibraryAssociation association = LibraryAssociation.getInstance();
        System.out.print("Enter the library id to add book : ");
        var id = sc.nextInt();
        var library = association.getLibraryById(id);
        if (library != null) {
            library.handleBookAddition();
        } else {
            System.out.println(Constants.LIBRARY_NOT_FOUND);
        }
    }
}
