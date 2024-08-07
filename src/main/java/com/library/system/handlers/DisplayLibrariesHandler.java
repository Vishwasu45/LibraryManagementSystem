package com.library.system.handlers;

import com.library.system.association.LibraryAssociation;

public class DisplayLibrariesHandler implements InputHandler {

    @Override
    public void handleInput() {
        var association = LibraryAssociation.getInstance();
        association.displayLibraries();
    }
}
