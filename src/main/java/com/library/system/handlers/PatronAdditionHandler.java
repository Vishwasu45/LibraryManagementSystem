package com.library.system.handlers;

import com.library.system.association.LibraryAssociation;
import com.library.system.common.Constants;
import com.library.system.common.ScannerProvider;

import java.util.Scanner;

public class PatronAdditionHandler implements InputHandler {

    private static final Scanner sc = ScannerProvider.getInstance().getScanner();

    @Override
    public void handleInput() {
        System.out.print("Enter the library id to add patron : ");
        var id = sc.nextInt();
        var association = LibraryAssociation.getInstance();
        var library = association.getLibraryById(id);
        if (library != null) {
            library.handlePatronAddition();
        } else {
            System.out.println(Constants.LIBRARY_NOT_FOUND);
        }
    }
}
