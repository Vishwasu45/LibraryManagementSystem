package com.library.system.handlers;

import com.library.system.association.LibraryAssociation;
import com.library.system.common.ScannerProvider;

import java.util.Scanner;

import static com.library.system.common.Constants.LIBRARY_NOT_FOUND;

public class ReturnBookHandler implements InputHandler {

    private static final Scanner sc = ScannerProvider.getInstance().getScanner();

    @Override
    public void handleInput() {
        System.out.print("Enter the library id to return book : ");
        var id = sc.nextInt();
        var association = LibraryAssociation.getInstance();
        var library = association.getLibraryById(id);
        if (library != null) {
            library.handleReturnBook();
        } else {
            System.out.println(LIBRARY_NOT_FOUND);
        }
    }
}
