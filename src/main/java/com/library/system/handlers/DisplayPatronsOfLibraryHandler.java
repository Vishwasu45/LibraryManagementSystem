package com.library.system.handlers;

import com.library.system.association.LibraryAssociation;
import com.library.system.common.ScannerProvider;

import java.util.Scanner;

import static com.library.system.common.Constants.LIBRARY_NOT_FOUND;

public class DisplayPatronsOfLibraryHandler implements InputHandler {

    private static final Scanner sc = ScannerProvider.getInstance().getScanner();

    @Override
    public void handleInput() {
        System.out.print("Enter the library id to display patrons : ");
        var id = sc.nextInt();
        var association = LibraryAssociation.getInstance();
        var library = association.getLibraryById(id);
        if (library != null) {
            library.displayPatrons();
        } else {
            System.out.println(LIBRARY_NOT_FOUND);
        }
    }
}